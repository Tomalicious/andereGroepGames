package com.vdab.commandpattern;

import com.vdab.domain.Borrow;
import com.vdab.services.BorrowService;

import java.util.List;

public class ListBorr implements Command {

    BorrowService borrowService = new BorrowService();
    @Override
    public void execute() throws Exception {

        List<Borrow> borrowList = borrowService.listStillBorrowed();
        for (Borrow b : borrowList) {
            System.out.println(b.getGame().getGameName() + " " + b.getBorrower().getBorrowerName() + " " + b.getBorrowDate());
        }

    }
}
