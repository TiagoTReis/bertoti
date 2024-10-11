import org.telegram.telegrambots.client.okhttp.OkHttpTelegramClient;
import org.telegram.telegrambots.longpolling.util.LongPollingSingleThreadUpdateConsumer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.TelegramClient;
import io.github.ollama4j.OllamaAPI;
import io.github.ollama4j.exceptions.OllamaBaseException;
import io.github.ollama4j.models.response.OllamaResult;
import io.github.ollama4j.utils.OptionsBuilder;

import java.io.IOException;

public class MyAmazingBot implements LongPollingSingleThreadUpdateConsumer {
    private final TelegramClient telegramClient;
    private final OllamaAPI ollamaAPI;

    public MyAmazingBot(String botToken) {
        telegramClient = new OkHttpTelegramClient(botToken);
        ollamaAPI = new OllamaAPI("http://localhost:11434/");
        ollamaAPI.setRequestTimeoutSeconds(200);
    }

    @Override
    public void consume(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();

            String responseText = queryGemma(messageText);

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
