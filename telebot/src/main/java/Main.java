
import org.telegram.telegrambots.longpolling.TelegramBotsLongPollingApplication;


public class Main {
    public static void main(String[] args) {
        String botToken = "6840395942:AAG5XPiG768DQEJTIEfWdMeoq3TmHC3hTsY";
        try (TelegramBotsLongPollingApplication botsApplication = new TelegramBotsLongPollingApplication()) {
            botsApplication.registerBot(botToken, new MyAmazingBot(botToken));
            System.out.println("MyAmazingBot successfully started!");
            Thread.currentThread().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
