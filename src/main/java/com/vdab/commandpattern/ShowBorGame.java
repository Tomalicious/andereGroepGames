package com.vdab.commandpattern;

import com.vdab.repositories.NotFoundException;
import com.vdab.services.BorrowService;

import java.util.Scanner;

public class ShowBorGame implements Command {

    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws Exception, NotFoundException {

        BorrowService borrowService = new BorrowService();

        borrowService.showBorrowedGames().stream().forEach(borrow -> System.out.format("Game name : %-40s | Borrower name : %-25s | Borrow date : %-12s | return date : %-12s %n",borrow.getGame().getGameName(),borrow.getBorrower().getBorrowerName(),borrow.getBorrowDate(),borrow.getReturnDate()));

        System.out.println("Do you wish to choose a borrower by name ? ");
        System.out.println("1.search by name " +
                "\n2. Quit ");
        int choice = scanner.nextInt();
        if (choice == 1) {
            Invoke.OPTION9.getCommand().execute();

        }


    }
}
