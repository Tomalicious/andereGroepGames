package com.vdab.commandpattern;

import com.vdab.repositories.BorrowerRepository;
import com.vdab.repositories.NotFoundException;
import com.vdab.services.BorrowService;
import com.vdab.services.BorrowerService;

import java.util.Scanner;

public class SearchBor implements Command {
    BorrowerService borrowerService = new BorrowerService();
    Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() throws NotFoundException {


        System.out.println("type in the name of the borrower you wish to search for ? ");
        borrowerService.searchBorrowerByName(scanner.next()).stream().forEach(borrower -> System.out.format("Borrower name : %-30s | City : %-15s | Email : %-30s | Telephone : %-15s %n",borrower.getBorrowerName(),borrower.getCity(),borrower.getEmail(),borrower.getTelephone()));
        System.out.println();


    }
}
