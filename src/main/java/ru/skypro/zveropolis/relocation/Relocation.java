package ru.skypro.zveropolis.relocation;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.skypro.zveropolis.TelegramBotSendMessage;
import ru.skypro.zveropolis.model.User;
import ru.skypro.zveropolis.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Relocation {
    private final UserRepository userRepository;
    private final StartMenu startMenu;
    private Map<Long, StateBot> states = new HashMap<>();

    public void doCrossroads(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            checkUser(chatId);
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            checkUser(chatId);
        }
    }

    private boolean checkUser(Long chatId) {
        if (states.containsKey(chatId)) {
            return true;
        }
        User user = new User();
        user.setChatId(chatId);
        userRepository.save(user);
        states.put(chatId, StateBot.START_MENU);
        return false;
    }

    private State getStateFromText(Update update) {
        Long chatId = update.getMessage().getChatId();
        StateBot stateBot = states.get(chatId);
        switch (stateBot) {
            case START_MENU -> {
                return startMenu;
            }
        }
        throw new RuntimeException();
        //todo исправить
    }
}
