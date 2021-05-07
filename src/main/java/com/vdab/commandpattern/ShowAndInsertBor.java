package com.vdab.commandpattern;

import com.vdab.domain.Borrow;
import com.vdab.domain.Borrower;
import com.vdab.domain.Game;
import com.vdab.services.BorrowService;
import com.vdab.services.BorrowerService;
import com.vdab.services.GameService;

import java.util.List;
import java.util.Scanner;

public class ShowAndInsertBor implements Command {

    GameService gameService= new GameService();
    Scanner scanner= new Scanner(System.in);
    BorrowService borrowService = new BorrowService();
    BorrowerService borrowerService = new BorrowerService();
    @Override
    public void execute() throws Exception {

        gameService.showAllGames2().stream().forEach(game -> System.out.format("Game id : %-10s | Game name : %-40s %n",game.getId(),game.getGameName()));

        System.out.println("Please enter the id of the game you want to borrow");
        int choice = scanner.nextInt();
        List<Borrow> borrowList = borrowService.listStillBorrowed();
        for (Borrow b : borrowList) {
            if (choice == b.getGame().getId()) {
                System.out.println("game already lent out ");
            }
        }
        Game game = gameService.findByID(choice);
        System.out.println(game.toString());
        System.out.println("--------------------");
        List<Borrower>borrowerList= borrowerService.showBorrowerList();
        for(Borrower b : borrowerList){
            System.out.println(b.getId()+" "+b.getBorrowerName());
        }
        System.out.println();
        System.out.println("Please enter the id of the borrower that wishes to borrow the game");
        int borrowerId = scanner.nextInt();
        Borrower borrower = borrowerService.findById(borrowerId);
        borrowService.updateLoan(choice,borrower);
        System.out.println("Loan registered for : " + game.getGameName() + " to : "+ borrower.getBorrowerName());

    }
}
