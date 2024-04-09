package ru.skypro.zveropolis.relocation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Update;
import ru.skypro.zveropolis.model.Users;
import ru.skypro.zveropolis.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class Relocation {
    private final UserRepository userRepository;
    private final StartMenu startMenu;
    private Map<Long, StateBot> stateMap = new HashMap<>();

    public void doCrossroads(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            checkUser(chatId);
            State state = getState(chatId);
            state.execute(update);
        } else if (update.hasCallbackQuery()) {
            Long chatId = update.getCallbackQuery().getMessage().getChatId();
            checkUser(chatId);
            State state = getState(chatId);
            state.execute(update);
        }
    }

    private boolean checkUser(Long chatId) {
        if (stateMap.containsKey(chatId)) {
            return true;
        }
        Users users = new Users();
        users.setChatId(chatId);
        userRepository.save(users);
        stateMap.put(chatId, StateBot.START_MENU);
        return false;
    }

    private State getState(Long chatId) {
        StateBot stateBot = stateMap.get(chatId);
        switch (stateBot) {
            case START_MENU -> {
                return startMenu;
            }
        }
        throw new RuntimeException();
        //todo исправить
    }
}
