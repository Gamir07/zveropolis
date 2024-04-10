package ru.skypro.zveropolis.relocation;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.skypro.zveropolis.TelegramBotSendMessage;

import java.util.ArrayList;
import java.util.List;

@Service

public class StartMenu implements State {
    private final TelegramBotSendMessage telegramBotSendMessage;
    private String CAT_SHELTER = "CAT_SHELTER";
    private String DOG_SHELTER = "DOG_SHELTER";

    public StartMenu(@Lazy TelegramBotSendMessage telegramBotSendMessage) {
        this.telegramBotSendMessage = telegramBotSendMessage;
    }

    @Override
    public void execute(Update update) {
        if(update.hasCallbackQuery()){

        } else if (update.hasMessage() && update.getMessage().hasText() && update.getMessage().getText().equals("/start")) {
            sendMessageAtText(update);
        }
    }

    @Override
    public InlineKeyboardMarkup createInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> button = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        InlineKeyboardButton catShelter = new InlineKeyboardButton("Приют для кошек");
        catShelter.setCallbackData(CAT_SHELTER);
        buttonRow1.add(catShelter);
        InlineKeyboardButton dogShelter = new InlineKeyboardButton("Приют для собак");
        dogShelter.setCallbackData(DOG_SHELTER);
        buttonRow2.add(dogShelter);
        button.add(buttonRow1);
        button.add(buttonRow2);
        inlineKeyboardMarkup.setKeyboard(button);
        return inlineKeyboardMarkup;
    }

    public Message sendMessageAtText(Update update){
        Long chatId = update.getMessage().getChatId();
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("Hi");
        sendMessage.setReplyMarkup(createInlineKeyboardMarkup());
        return telegramBotSendMessage.sendMessage(sendMessage);
    }
}
