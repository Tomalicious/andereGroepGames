package com.vdab.services;

import com.vdab.domain.Borrower;
import com.vdab.repositories.BorrowerRepository;

public class BorrowerService {

    BorrowerRepository borrowerRepository = new BorrowerRepository();

    public Borrower findInfoBorrower() {
        return borrowerRepository.findInfoBorrower();

    }
}
