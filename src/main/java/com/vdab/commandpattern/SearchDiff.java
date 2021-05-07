package com.vdab.commandpattern;

import com.vdab.domain.Game;
import com.vdab.services.GameService;

import java.util.List;
import java.util.Scanner;

public class SearchDiff implements Command {
    GameService gameService= new GameService();
    Scanner scanner= new Scanner(System.in);
    @Override
    public void execute() throws Exception {
        System.out.println("please select a difficulty ? " +
                "\n1. very easy " +
                "\n2. easy " +
                "\n3. average " +
                "\n4. difficult " +
                "\n5. very difficult ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice < 6) {

            List<Game> gameList = gameService.searchByDifficulty(choice);
            for (Game g : gameList) {
                System.out.println(g.getGameName() + " " + g.getEditor() + " " + g.getPrice() + " " + g.getDifficulty().getDifficultyName());
                System.out.println("---------------------------------------");
            }
        } else {
            System.out.println(" error ");
        }

    }
}
