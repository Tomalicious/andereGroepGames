package com.vdab.services;

import com.vdab.domain.Borrow;
import com.vdab.repositories.BorrowRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class BorrowServiceTestwhiteBox {

    //veel uitgebreider testen

    @Mock
    private BorrowRepository borrowRepository;
    @InjectMocks
    private BorrowService borrowService = new BorrowService();

    @BeforeEach
    public void setup(){
        List<Borrow>borrowList=new ArrayList<>();
        borrowList.add(Borrow.builder()
                        .id(4)
                        .build()
                        );
        Mockito.lenient().when(borrowRepository.listStillBorrowed()).thenReturn(borrowList);
    }
    @Test
    public void testUpdateLoan(){
        borrowService.updateLoan(1,null);
        Mockito.verify(borrowRepository).updateLoan(1,null);
    }

    @Test
    public void testListStillBorrowedNotEMpty(){
       List<Borrow>borrowList= borrowService.listStillBorrowed();
       Mockito.verify(borrowRepository).listStillBorrowed();
        Assertions.assertFalse(borrowList.isEmpty());
    }
}
