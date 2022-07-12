package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады 2");
        boolean containsGame = store.containsGame(game);

        assertTrue(store.containsGame(game1));
    }

    @Test
    public void shouldPlayTime() {

        GameStore store = new GameStore();
        Player player = new Player("Petya");

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game1 = store.publishGame("Нетология Баттл Онлайн2", "Аркады2");
        store.addPlayTime("Petya", 1);
        store.addPlayTime("Vasya", 1);
        store.addPlayTime("Anna", 1);
        store.getMostPlayer();

    }

    // другие ваши тесты
}
