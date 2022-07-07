package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.NullString;

import java.util.Objects;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void checkMostPlayedGenre() {
        GameStore store = new GameStore();
        Game arcade = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game arcade2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        Game shooter = store.publishGame("Нетология Баттл Онлайн", "Шутер");

        Player player = new Player("Petya");
        player.installGame(arcade);
        player.installGame(arcade2);
        player.installGame(shooter);

        player.play(arcade, 4);
        player.play(arcade2, 3);
        player.play(shooter, 2);

        Game expected = arcade;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void checkSumCounter() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 5;
        int actual = player.play(game, 2);
        assertEquals(expected, actual);
    }


    @Test
    public void MostPlayedGenre() {
        GameStore store = new GameStore();
        Game arcade = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game arcade2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        Game shooter = store.publishGame("Нетология Баттл Онлайн", "Шутер");

        Player player = new Player("Petya");
        player.installGame(arcade);
        player.installGame(arcade2);
        player.installGame(shooter);

        player.play(arcade, 3);
        player.play(arcade2, 3);
        player.play(shooter, 3);

        Game expected = arcade;
        Game actual = player.mostPlayerByGenre("Аркады");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumGenreGame() {
        GameStore store = new GameStore();
        Game arcade = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game arcade2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        Game shooter = store.publishGame("Нетология Баттл Онлайн", "Шутер");

        Player player = new Player("Petya");
        player.installGame(arcade);
        player.installGame(arcade2);
        player.installGame(shooter);

        player.play(arcade, 3);
        player.play(arcade2, 2);
        player.play(shooter, 1);

        int expected = 4;
        int actual = player.sumGenre(arcade.getGenre());
        assertEquals(expected, actual);
    }

    @Test
    public void countInstallGame() {
        GameStore store = new GameStore();
        Game arcade = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game arcade2 = store.publishGame("Нетология Баттл Онлайн 2", "Аркады");
        Game shooter = store.publishGame("Нетология Баттл Онлайн", "Шутер");

        Player player = new Player("Petya");
        player.play(arcade, 3);
        player.play(arcade2, 2);
        player.play(shooter, 1);

        Game expected = shooter;
        Game actual = player.installGame(shooter);
        assertEquals(expected, actual);
    }

}
