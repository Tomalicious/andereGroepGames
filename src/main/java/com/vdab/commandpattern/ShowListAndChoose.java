package com.vdab.commandpattern;

import com.vdab.domain.Game;
import com.vdab.repositories.NotFoundException;
import com.vdab.services.GameService;

import java.util.Locale;
import java.util.Scanner;

public class ShowListAndChoose implements Command {
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws Exception, NotFoundException {

        GameService gameService = new GameService();

        Invoke.OPTION5.getCommand().execute();

        System.out.println("Enter the name of the game you want to find");
        Game game = gameService.showAndChoose(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getDifficulty().getDifficultyName() + " " + game.getCategory().getCategoryName());
        System.out.println("--------------------------------");

    }
}
