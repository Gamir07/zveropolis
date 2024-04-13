package ru.skypro.zveropolis.relocation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import ru.skypro.zveropolis.TelegramBotSendMessage;

@Service
public class CatMenu implements State{
    private final TelegramBotSendMessage telegramBotSendMessage;

    public CatMenu(@Lazy TelegramBotSendMessage telegramBotSendMessage) {
        this.telegramBotSendMessage = telegramBotSendMessage;
    }

    @Override
    public void execute(Update update) {
        if(update.hasCallbackQuery()){
            //sendMessageAtCallback(update);
            sendMessage(update);

        } else if (update.hasMessage() && update.getMessage().hasText()) {
            //sendMessageAtText(update);
        }
    }




    public Message sendMessage(Update update){
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Cat");
        sendMessage.setReplyMarkup(createInlineKeyboardMarkup());
        return telegramBotSendMessage.sendMessage(sendMessage);
    }



    @Override
    public InlineKeyboardMarkup createInlineKeyboardMarkup() {
        return null;
    }
}
