package com.vdab.commandpattern;

import com.vdab.domain.Game;
import com.vdab.services.CategoryService;
import com.vdab.services.GameService;

public class ShowFiGame implements Command {

    @Override
    public void execute() {

        GameService gameService = new GameService();

        Game game = gameService.findFifthGame();
        System.out.println("printing out game 5 " + game.toString());
        System.out.println("-----------------------------------------------");

    }
}
