package com.vdab.services;

import com.vdab.domain.Borrow;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BorrowServiceTest {

    private BorrowService borrowService = new BorrowService();

    @Test
    public void testShowBorrowedGames(){
        List<Borrow>borrowList=borrowService.showBorrowedGames();
        Assertions.assertFalse(borrowList.isEmpty());
    }

    @Test
    public void testListStillBorrowed(){
        List<Borrow>borrowList=borrowService.showBorrowedGames();
        Assertions.assertFalse(borrowList.isEmpty());
    }
}