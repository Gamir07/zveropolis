package ru.skypro.zveropolis.relocation;

import org.telegram.telegrambots.meta.api.objects.Update;

public interface State {
    void execute(Update update);
}
