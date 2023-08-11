package Pages;

import org.junit.Test;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class bot extends TelegramLongPollingBot {
    private String botToken = "6114325890:AAErQxxj4PYJ4k2wzSd4vavrLFO0E1W15tM";
    private String botUsername = "@sdsdsdsdsdsdsdsd_bot";

    @Override
    public void onUpdateReceived(Update update) {
        // Обработка входящих сообщений, если требуется
    }

    public void sendMessage(String messageText) {
        SendMessage message = new SendMessage(); // Создаем объект для отправки сообщения
        message.setChatId("595052554");
        message.setText(messageText);
        try {
            execute(message); // Отправляем сообщение
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }


}
