import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final String botToken;

    public MyAmazingBot(String botToken) {
        this.botToken = botToken;
        telegramClient = new OkHttpTelegramClient(botToken);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            long chatId = update.getMessage().getChatId();
            String fileId = update.getMessage().getPhoto().get(update.getMessage().getPhoto().size() - 1).getFileId();

            // Baixar a imagem e processar
            String imagePath = null;
            try {
                imagePath = downloadImage(fileId);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }

            String responseText = recognizeTextInImage(imagePath);

            SendMessage message = SendMessage.builder()
                    .chatId(chatId)
                    .text(responseText)
                    .build();

            try {
                telegramClient.execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    private String downloadImage(String fileId) throws TelegramApiException {
        try {
            GetFile getFileMethod = new GetFile(fileId);
            String filePath = telegramClient.execute(getFileMethod).getFilePath();
            String fileUrl = "https://api.telegram.org/file/bot" + botToken + "/" + filePath;

            // Salvar a imagem em um arquivo local
            String localImagePath = "downloaded_image_" + System.currentTimeMillis() + ".jpg";
            try (InputStream in = new URL(fileUrl).openStream()) {
                Files.copy(in, Paths.get(localImagePath), StandardCopyOption.REPLACE_EXISTING);
            }

            return localImagePath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String recognizeTextInImage(String imagePath) {
        if (imagePath == null) {
            return "Erro ao baixar a imagem.";
        }

        ITesseract tesseract = new Tesseract();
        tesseract.setDatapath("C:/Program Files/Tesseract-OCR/tessdata"); // Altere se necessário
        tesseract.setLanguage("eng"); // Use "por" para português

        try {
            File imageFile = new File(imagePath);
            return tesseract.doOCR(imageFile);
        } catch (TesseractException e) {
            e.printStackTrace();
            return "Erro ao reconhecer texto na imagem.";
        }
    }
}
