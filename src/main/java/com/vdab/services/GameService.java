package com.vdab.services;

import com.vdab.Main;
import com.vdab.domain.Game;
import com.vdab.repositories.GameRepository;
import com.vdab.repositories.NotFoundException;

import java.sql.SQLDataException;
import java.util.List;

public class GameService {
    GameRepository gameRepository = new GameRepository();


    public Game findFifthGame(){
        return gameRepository.findFifthGame();
    }


    public Game findGameByPartName(String string) throws NotFoundException {
            return gameRepository.findGameByPartName(string);
    }

    public List<Game> showAllGames() {
        return gameRepository.showAllGames();
    }

    public Game showAndChoose(String string) throws NotFoundException {
        return gameRepository.showAndChoose(string);
    }

    public List<Game> searchByDifficulty(int id) {
        return gameRepository.searchByDifficulty(id);
    }

    public List<Game> showAllGames2() {
        return gameRepository.showAllGames2();
    }

    public Game findByID(int id) {

        return gameRepository.findByID(id);
    }

}
