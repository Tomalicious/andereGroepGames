package com.vdab.services;

import com.vdab.domain.Game;
import com.vdab.repositories.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameServiceTest {

    // cntl shift t
    // test is altijd public void

    private GameService gameService = new GameService();

    @Test
    public void testFindById(){
        Game findById = gameService.findByID(1);
        Assertions.assertAll(
                ()-> Assertions.assertEquals("Getting started with waste",findById.getGameName()),
                ()-> Assertions.assertEquals("De Helix",findById.getEditor()),
                ()-> Assertions.assertEquals(2005,findById.getYearEdition()),
                ()-> Assertions.assertEquals("from 13y",findById.getAge()),
                ()-> Assertions.assertEquals(4,findById.getMinPlayers()),
                ()-> Assertions.assertEquals(20,findById.getMaxPlayers()),
                ()-> Assertions.assertEquals("educational",findById.getCategory().getCategoryName()),
                ()-> Assertions.assertEquals("46 min to 2h",findById.getPlayDuration()),
                ()-> Assertions.assertEquals("easy",findById.getDifficulty().getDifficultyName()),
                ()-> Assertions.assertEquals(7.5,findById.getPrice()),
                ()-> Assertions.assertEquals("aandeslagmetafval.jpg",findById.getImage())
               // ()-> Assertions.assertEquals("",findById.getAuthor())
        );
    }

    @Test
    public void testFindFifthGame() {
        Game fifthGame = gameService.findFifthGame();
        Assertions.assertAll(
                () -> Assertions.assertEquals("Abracadabra", fifthGame.getGameName()),
                () -> Assertions.assertEquals("DaVinci Games", fifthGame.getEditor()),
                () -> Assertions.assertEquals(2004, fifthGame.getYearEdition()),
                () -> Assertions.assertEquals("from 9 to 12y", fifthGame.getAge()),
                () -> Assertions.assertEquals(4, fifthGame.getMinPlayers()),
                () -> Assertions.assertEquals(6, fifthGame.getMaxPlayers()),
                () -> Assertions.assertEquals("strategy", fifthGame.getCategory().getCategoryName()),
                () -> Assertions.assertEquals("16 min to 45 min", fifthGame.getPlayDuration()),
                () -> Assertions.assertEquals("average", fifthGame.getDifficulty().getDifficultyName()),
                () -> Assertions.assertEquals(10.0, fifthGame.getPrice()),
                () -> Assertions.assertEquals("abracadabra.jpg", fifthGame.getImage()),
                () -> Assertions.assertEquals("Di Giorgio Domenico en Barletta Roberta", fifthGame.getAuthor())
        );
    }

    @Test
    public void testfindGameByPartName() throws NotFoundException {
        Game fifthGame = gameService.findGameByPartName("Abracadabra");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Abracadabra", fifthGame.getGameName()),
                () -> Assertions.assertEquals("DaVinci Games", fifthGame.getEditor()),
                () -> Assertions.assertEquals(2004, fifthGame.getYearEdition()),
                () -> Assertions.assertEquals("from 9 to 12y", fifthGame.getAge()),
                () -> Assertions.assertEquals(4, fifthGame.getMinPlayers()),
                () -> Assertions.assertEquals(6, fifthGame.getMaxPlayers()),
                () -> Assertions.assertEquals("strategy", fifthGame.getCategory().getCategoryName()),
                () -> Assertions.assertEquals("16 min to 45 min", fifthGame.getPlayDuration()),
                () -> Assertions.assertEquals("average", fifthGame.getDifficulty().getDifficultyName()),
                () -> Assertions.assertEquals(10.0, fifthGame.getPrice()),
                () -> Assertions.assertEquals("abracadabra.jpg", fifthGame.getImage()),
                () -> Assertions.assertEquals("Di Giorgio Domenico en Barletta Roberta", fifthGame.getAuthor())
        );
    }
    @Test
    public void testshowAndChoose() throws NotFoundException {
        Game fifthGame = gameService.showAndChoose("Abracadabra");
        Assertions.assertAll(
                () -> Assertions.assertEquals("Abracadabra", fifthGame.getGameName()),
                () -> Assertions.assertEquals("DaVinci Games", fifthGame.getEditor()),
                () -> Assertions.assertEquals(2004, fifthGame.getYearEdition()),
                () -> Assertions.assertEquals("from 9 to 12y", fifthGame.getAge()),
                () -> Assertions.assertEquals(4, fifthGame.getMinPlayers()),
                () -> Assertions.assertEquals(6, fifthGame.getMaxPlayers()),
                () -> Assertions.assertEquals("strategy", fifthGame.getCategory().getCategoryName()),
                () -> Assertions.assertEquals("16 min to 45 min", fifthGame.getPlayDuration()),
                () -> Assertions.assertEquals("average", fifthGame.getDifficulty().getDifficultyName()),
                () -> Assertions.assertEquals(10.0, fifthGame.getPrice()),
                () -> Assertions.assertEquals("abracadabra.jpg", fifthGame.getImage()),
                () -> Assertions.assertEquals("Di Giorgio Domenico en Barletta Roberta", fifthGame.getAuthor())
        );
    }
   @Test
    public void testShowAllGames(){
       List<Game> gameList = gameService.showAllGames();
       Assertions.assertFalse(gameList.isEmpty());
   }

   @Test
    public void testSearchByDifficulty(){
        List<Game>gameList= gameService.searchByDifficulty(1);
        Assertions.assertFalse(gameList.isEmpty());
   }

   @Test
    public void testShowAllGames2(){
        List<Game>gameList=gameService.showAllGames2();
        Assertions.assertFalse(gameList.isEmpty());
   }
    }
