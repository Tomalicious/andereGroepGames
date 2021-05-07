package com.vdab.commandpattern;

import com.vdab.services.GameService;

public class ShowAll implements Command {
    @Override
    public void execute() throws Exception{

        GameService gameService = new GameService();
        gameService.showAllGames().stream().forEach(game -> System.out.format("Game name : %-50s | Editor %-40s | Price : %-10s %n",game.getGameName(),game.getEditor(),game.getPrice()));
        System.out.println();


    }
}
