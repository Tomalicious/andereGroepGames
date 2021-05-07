package com.vdab.commandpattern;

import com.vdab.domain.Game;
import com.vdab.repositories.NotFoundException;
import com.vdab.services.GameService;

import java.util.Locale;
import java.util.Scanner;

public class GameOfChoice implements Command {

    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws Exception, NotFoundException {

        GameService gameService = new GameService();

        System.out.println("Enter part of the name or part of the name of the game ");
        Game game = gameService.findGameByPartName(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getAge() + " " + game.getAuthor() + " " + game.getPrice());
        System.out.println("------------------------------------------------");

    }

    }

