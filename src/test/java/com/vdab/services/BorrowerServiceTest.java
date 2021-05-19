package com.vdab.services;

import com.vdab.domain.Borrower;
import com.vdab.repositories.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerServiceTest {

    private BorrowerService borrowerService = new BorrowerService();

    @Test
    public void searchBorrowerByName() throws NotFoundException {
        List<Borrower>borrowerList=borrowerService.searchBorrowerByName("ch");
        Assertions.assertFalse(borrowerList.isEmpty());

    }

    @Test
    public void showBorrowerList() {
        List<Borrower>borrowerList=borrowerService.showBorrowerList();
        Assertions.assertFalse(borrowerList.isEmpty());
    }

    @Test
    public void findById() {
        Borrower findById = borrowerService.findById(1);
        Assertions.assertAll(
                ()-> Assertions.assertEquals("Jan Peeters",findById.getBorrowerName()),
                ()-> Assertions.assertEquals("Geel",findById.getCity()),
                ()-> Assertions.assertEquals("A",findById.getBusNumber()),
                ()-> Assertions.assertEquals("jan.peeters@khk.be",findById.getEmail()),
                ()-> Assertions.assertEquals("25",findById.getHouseNumber()),
                ()-> Assertions.assertEquals("2440",findById.getPostalCode()),
                ()-> Assertions.assertEquals("Begonialaan",findById.getStreet()),
                ()-> Assertions.assertEquals("014572810",findById.getTelephone()),
                ()-> Assertions.assertEquals(1,findById.getId())


        );
    }
}