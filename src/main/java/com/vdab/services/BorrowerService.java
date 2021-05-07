package com.vdab.services;

import com.vdab.domain.Borrower;
import com.vdab.repositories.BorrowerRepository;
import com.vdab.repositories.NotFoundException;

import java.util.List;

public class BorrowerService {

    BorrowerRepository borrowerRepository = new BorrowerRepository();

    public Borrower findInfoBorrower() {
        return borrowerRepository.findInfoBorrower();

    }

    public List<Borrower> searchBorrowerByName(String string) throws NotFoundException {
        return borrowerRepository.searchBorrowerByName(string);
    }

    public List<Borrower> showBorrowerList() {
        return borrowerRepository.showBorrowerList();
    }

    public Borrower findById(int borrowerId) {
        return borrowerRepository.findById(borrowerId);
    }
}
