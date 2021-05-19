package com.vdab.commandpattern;

import lombok.Getter;

// enum is een lijst

@Getter

public enum Invoke {
    OPTION0("0","0. Quit the game",new QuitCommand()),
    OPTION1("1","Show category for id",new ShowCatforId()),
    OPTION2("2","2. Show the fifth game",new ShowFiGame()),
    OPTION3("3","3. Show the first borrower",new FirstBorrower()),
    OPTION4("4","4. Show a game of your choice",new GameOfChoice()),
    OPTION5("5","5. Show all games",new ShowAll()),
    OPTION6("6","6. Show a list of games and choose a game",new ShowListAndChoose()),
    OPTION7("7","7.Show borrowed games",new ShowBorGame()),
    OPTION8("8","8. Advanced search : difficulty",new SearchDiff()),
    OPTION9("9","9. Complex search: borrowers",new SearchBor()),
    OPTION10("10","10. List still borrowed",new ListBorr()),
    OPTION11("11","11. Show all borrows , and insert a new borrow",new ShowAndInsertBor()),
    OPTION12("12","12. Show all borrows from last month and update a borrower id",new ShowBorMonthAndUpd()),
    ;


    private final String id;
    private final String displayOptions;
    private final Command command;

    Invoke(String id, String displayOptions , Command command) {


        this.id = id;
        this.displayOptions = displayOptions;
        this.command = command;
    }
}

