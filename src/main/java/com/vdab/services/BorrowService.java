package com.vdab.services;

import com.vdab.domain.Borrow;
import com.vdab.domain.Borrower;
import com.vdab.repositories.BorrowRepository;
import lombok.Data;
import lombok.experimental.SuperBuilder;


import java.util.List;

public class BorrowService {

    BorrowRepository borrowRepository=new BorrowRepository();

    public List<Borrow> showBorrowedGames() {
        return borrowRepository.showBorrowedGames();
    }

    public List<Borrow> listStillBorrowed() {
        return borrowRepository.listStillBorrowed();
    }

    public void updateLoan(int choice, Borrower borrower) {
        borrowRepository.updateLoan(choice,borrower);
    }
}


