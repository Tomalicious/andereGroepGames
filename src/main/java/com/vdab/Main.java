package com.vdab;

import com.vdab.domain.Borrower;
import com.vdab.domain.Category;
import com.vdab.domain.Game;
import com.vdab.services.BorrowerService;
import com.vdab.services.CategoryService;
import com.vdab.services.GameService;


import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
    CategoryService categoryService = new CategoryService();
    GameService gameService = new GameService();
    BorrowerService borrowerService =new BorrowerService();

    public static void main(String[] args) {

        System.out.println("Welcome to GameStop , designed by Margaux ");
        Main main = new Main();
        main.showInitialOptions();

    }

    public void showInitialOptions() {
        System.out.println("Please select an option ");
        System.out.println(
                "0. Quit the game . \n"+
                "1. Show category for id. \n"+
                "2. Show the fifth game . \n"+
                "3. Show the first borrower . \n"+
                "4. Show a game of your choice . \n"+
                "5. Show all games . \n"+
                "6. Show a list of games and choose a game . \n"+
                "7. Show borrowed games . \n"+
                "8. Advanced search : difficulty. \n"+
                "9. Complex search: borrowers . \n"+
                "10. New way . \n"+
                "11. Show all borrows , and insert a new borrow . \n"+
                "12. Show all borrows from last month and update a borrower id \n" +
                        "---------------------------\n" +
                        "That were all choose options . Choose your options :  \n");

        int choice = scanner.nextInt();
        switch (choice){
            case 0:
                break;
            case 1:
                findCategoryOne();
                showInitialOptions();
                break;
            case 2:
                findFifthGame();
                showInitialOptions();
                break;
            case 3:
                findInfoBorrower();
                showInitialOptions();
            case 4:
                findGameByPartName();
                showInitialOptions();
            case 5:
                showAllGames();
                showInitialOptions();
            case 6:
                showAndChoose();
                showInitialOptions();
            case 7:
                showInitialOptions();
            case 8:
                showInitialOptions();
            case 9:
                showInitialOptions();
            case 10:
                showInitialOptions();
            case 11:
                showInitialOptions();

        }
    }


    private void findCategoryOne() {
        Category category = categoryService.findCategoryOne();
        System.out.println("the category and the id are : " + category.getCategoryName()+ " "+ category.getId());
        System.out.println("-----------------------------------------------------------------");
    }
    private void findFifthGame() {
        Game game = gameService.findFifthGame();
        System.out.println("printing out game 5 "+ game.toString());
        System.out.println("-----------------------------------------------");
    }
    private void findInfoBorrower() {
        Borrower borrower = borrowerService.findInfoBorrower();
        System.out.println("We are printing out the name and the city of the borrower : "+ borrower.getBorrowerName()+ " " + borrower.getCity());
        System.out.println("-----------------------------------");
    }
    public void findGameByPartName() {
        System.out.println("Enter part of the name or part of the name of the game ");
        Game game = gameService.findGameByPartName(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName()+ " " + game.getAge()+ " "+ game.getAuthor()+ " "+ game.getPrice());
        System.out.println("------------------------------------------------");
    }
    private void showAllGames() {
        List<Game>gameList= gameService.showAllGames();
        for(Game g : gameList){
            System.out.println(g.getGameName()+" "+ g.getEditor()+ " "+ g.getPrice());
            System.out.println("---------------------------------------");
        }
    }
    private void showAndChoose() {
        showAllGames();
        System.out.println("Enter the name of the game you want to find");
        Game game = gameService.showAndChoose(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName()+" "+game.getDifficulty().getDifficultyName()+" "+game.getCategory().getCategoryName());
        System.out.println("--------------------------------");
    }




}
