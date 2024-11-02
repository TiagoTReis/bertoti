import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.GetFile;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final OllamaAPI ollamaAPI;
    private final String botToken; // Variável de instância para o token

    public MyAmazingBot(String botToken) {
        this.botToken = botToken; // Armazenar o token
        telegramClient = new OkHttpTelegramClient(botToken);
        ollamaAPI = new OllamaAPI("http://localhost:11434/");
        ollamaAPI.setRequestTimeoutSeconds(200);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasPhoto()) {
            long chatId = update.getMessage().getChatId();
            String fileId = update.getMessage().getPhoto().get(update.getMessage().getPhoto().size() - 1).getFileId();

            // Baixar a imagem e processar
            String imagePath = downloadImage(fileId);
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

    private String downloadImage(String fileId) {
        try {
            // Criar GetFile passando fileId diretamente
            GetFile getFileMethod = new GetFile(fileId);
            String filePath = telegramClient.execute(getFileMethod).getFilePath();
            String fileUrl = "https://api.telegram.org/file/bot" + botToken + "/" + filePath; // Usar a variável botToken

            // Baixar a imagem para um diretório local
            InputStream in = new URL(fileUrl).openStream();
            String imagePath = "downloaded_image_" + System.currentTimeMillis() + ".jpg"; // Nome único
            Files.copy(in, Paths.get(imagePath), StandardCopyOption.REPLACE_EXISTING);
            in.close();

            return imagePath; // Retorne o caminho da imagem baixada
        } catch (IOException | TelegramApiException e) {
            e.printStackTrace();
            return null; // Retorne null em caso de erro
        }
    }

    private String recognizeTextInImage(String imagePath) {
        if (imagePath == null) {
            return "Erro ao baixar a imagem.";
        }

        try {
            // Use a API do Gemma para reconhecer texto na imagem
            OllamaResult result = ollamaAPI.generate("gemma2:2b", "Recognize text in " + imagePath, true, new OptionsBuilder().build());
            return result.getResponse();
        } catch (OllamaBaseException | IOException | InterruptedException e) {
            e.printStackTrace();
            return "Desculpe, não consegui reconhecer o texto.";
        }
    }

    private String queryGemma(String prompt) {
        try {
            OllamaResult result = ollamaAPI.generate("gemma2:2b", prompt, true, new OptionsBuilder().build());
            return result.getResponse();
        } catch (OllamaBaseException | IOException | InterruptedException e) {
            e.printStackTrace();
            return "Desculpe, não consegui responder.";
        }
    }
}
