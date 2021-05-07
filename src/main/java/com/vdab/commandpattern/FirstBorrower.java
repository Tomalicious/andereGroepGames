package com.vdab.commandpattern;

import com.vdab.domain.Borrower;
import com.vdab.services.BorrowerService;

public class FirstBorrower implements Command {
    @Override
    public void execute() throws Exception {

        BorrowerService borrowerService = new BorrowerService();

        Borrower borrower = borrowerService.findInfoBorrower();
        System.out.println("We are printing out the name and the city of the borrower : " + borrower.getBorrowerName() + " " + borrower.getCity());
        System.out.println("-----------------------------------");

    }
}
