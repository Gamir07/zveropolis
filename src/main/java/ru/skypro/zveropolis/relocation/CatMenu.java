package ru.skypro.zveropolis.relocation;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import ru.skypro.zveropolis.TelegramBotSendMessage;
import ru.skypro.zveropolis.model.Shelter;
import ru.skypro.zveropolis.model.TypeOfAnimal;
import ru.skypro.zveropolis.repository.ShelterRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatMenu implements State{
    private final TelegramBotSendMessage telegramBotSendMessage;
    private final ShelterRepository shelterRepository;
    private final String INFORMATION_ABOUT_SHELTER = "INFORMATION_ABOUT_SHELTER";
    private final String HOW_TAKE_PET = "HOW_TAKE_PET";
    private final String SEND_REPORT = "SEND_REPORT";
    private final String CALL_VOLUNTEER = "CALL_VOLUNTEER";
    private final String BACK = "BACK";
    private final String CAT_SHELTER = "CAT_SHELTER";



    public CatMenu(@Lazy TelegramBotSendMessage telegramBotSendMessage, ShelterRepository shelterRepository) {
        this.telegramBotSendMessage = telegramBotSendMessage;
        this.shelterRepository = shelterRepository;
    }

    @Override
    public void execute(Update update) {
        if(update.hasCallbackQuery()){
            sendMessageAtCallback(update);

        } else if (update.hasMessage() && update.getMessage().hasText()) {
            //sendMessageAtText(update);
        }
    }

    @Override
    public InlineKeyboardMarkup createInlineKeyboardMarkup() {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<List<InlineKeyboardButton>> button = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow1 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow2 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow3 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow4 = new ArrayList<>();
        List<InlineKeyboardButton> buttonRow5 = new ArrayList<>();

        InlineKeyboardButton informationAboutShelter = new InlineKeyboardButton("Информация о приюте для кошек");
        informationAboutShelter.setCallbackData(INFORMATION_ABOUT_SHELTER);
        buttonRow1.add(informationAboutShelter);

        InlineKeyboardButton howTakePet = new InlineKeyboardButton("Как взять животное из приюта");
        howTakePet.setCallbackData(HOW_TAKE_PET);
        buttonRow2.add(howTakePet);

        InlineKeyboardButton sendReport = new InlineKeyboardButton("Прислать отчёт");
        sendReport.setCallbackData(SEND_REPORT);
        buttonRow3.add(sendReport);

        InlineKeyboardButton callVolunteer = new InlineKeyboardButton("Позвать волонтёра");
        callVolunteer.setCallbackData(CALL_VOLUNTEER);
        buttonRow4.add(callVolunteer);

        InlineKeyboardButton back = new InlineKeyboardButton("Назад");
        back.setCallbackData(BACK);
        buttonRow5.add(back);

        button.add(buttonRow1);
        button.add(buttonRow2);
        button.add(buttonRow3);
        button.add(buttonRow4);
        button.add(buttonRow5);

        inlineKeyboardMarkup.setKeyboard(button);
        return inlineKeyboardMarkup;
    }

    private SendMessage createSendMessage(String text, Long chatId){
        SendMessage createSendMessage = new SendMessage();
        createSendMessage.setText(text);
        createSendMessage.setChatId(chatId);
        createSendMessage.setReplyMarkup(createInlineKeyboardMarkup());
        return createSendMessage;
    }

    public void sendMessageAtCallback(Update update) {
        Long chatId = update.getCallbackQuery().getMessage().getChatId();
        String data = update.getCallbackQuery().getData();
        Shelter firstByTypeOfAnimal = shelterRepository.findFirstByTypeOfAnimal(TypeOfAnimal.CAT);
        switch (data) {
            case CAT_SHELTER -> {
                telegramBotSendMessage.sendMessage(createSendMessage(
                        firstByTypeOfAnimal.getGreeting(), chatId));
            }
            case INFORMATION_ABOUT_SHELTER -> {

            }
            case HOW_TAKE_PET -> {

            }
            case SEND_REPORT -> {

            }
            case CALL_VOLUNTEER -> {

            }
            case BACK -> {

            }
        }
    }
}
