package com.vdab.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@Data
@SuperBuilder

public class Borrow extends BaseEntity{

    private Game game;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate;

}
