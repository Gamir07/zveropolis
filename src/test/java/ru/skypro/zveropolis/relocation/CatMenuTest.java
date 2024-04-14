package ru.skypro.zveropolis.relocation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.zveropolis.repository.ShelterRepository;
import ru.skypro.zveropolis.repository.SubscriberRepository;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CatMenuTest {


    @InjectMocks
    CatMenu out;

    @Mock
    ShelterRepository shelterRepository;

    @Mock
    SubscriberRepository subscriberRepository;

    @Test
    void execute() {
    }

    @Test
    void createInlineKeyboardMarkup() {
    }

    @Test
    void sendMessageAtCallback() {
    }
}