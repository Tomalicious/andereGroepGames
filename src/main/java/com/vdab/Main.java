package com.vdab;

import com.vdab.domain.Borrow;
import com.vdab.domain.Borrower;
import com.vdab.domain.Category;
import com.vdab.domain.Game;
import com.vdab.services.BorrowService;
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
    BorrowerService borrowerService = new BorrowerService();
    BorrowService borrowService = new BorrowService();

    public static void main(String[] args) {

        System.out.println("Welcome to GameStop , designed by Margaux ");
        Main main = new Main();
        main.showInitialOptions();

    }

    public void showInitialOptions() {
        System.out.println("Please select an option ");
        System.out.println(
                "0. Quit the game  \n" +
                        "1. Show category for id. \n" +
                        "2. Show the fifth game . \n" +
                        "3. Show the first borrower . \n" +
                        "4. Show a game of your choice . \n" +
                        "5. Show all games . \n" +
                        "6. Show a list of games and choose a game . \n" +
                        "7. Show borrowed games . \n" +
                        "8. Advanced search : difficulty \n" +
                        "9. Complex search: borrowers  \n" +
                        "10. List still borrowed   \n" +
                        "11. Show all borrows , and insert a new borrow . \n" +
                        "12. Show all borrows from last month and update a borrower id \n" +
                        "---------------------------\n" +
                        "That were all choose options . Choose your options :  \n");


        int choice = scanner.nextInt();
        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:
                findCategoryOne();
                break;
            case 2:
                findFifthGame();
                break;
            case 3:
                findInfoBorrower();
                break;
            case 4:
                findGameByPartName();
                break;
            case 5:
                showAllGames();
                break;
            case 6:
                showAndChoose();
                break;
            case 7:
                showBorrowedGames();
                break;
            case 8:
                searchByDifficulty();
                break;
            case 9:
                searchBorrowerByName();
                break;
            case 10:
                listStillBorrowed();
                break;
            case 11:
                registerNewLoan();
                break;
            default:
                System.out.println("Wrong input ");
                break;
        }

    }


    private void findCategoryOne() {
        Category category = categoryService.findCategoryOne();
        System.out.println("the category and the id are : " + category.getCategoryName() + " " + category.getId());
        System.out.println("-----------------------------------------------------------------");
        showInitialOptions();
    }

    private void findFifthGame() {
        Game game = gameService.findFifthGame();
        System.out.println("printing out game 5 " + game.toString());
        System.out.println("-----------------------------------------------");
        showInitialOptions();
    }

    private void findInfoBorrower() {
        Borrower borrower = borrowerService.findInfoBorrower();
        System.out.println("We are printing out the name and the city of the borrower : " + borrower.getBorrowerName() + " " + borrower.getCity());
        System.out.println("-----------------------------------");
        showInitialOptions();
    }

    public void findGameByPartName() {
        System.out.println("Enter part of the name or part of the name of the game ");
        Game game = gameService.findGameByPartName(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getAge() + " " + game.getAuthor() + " " + game.getPrice());
        System.out.println("------------------------------------------------");
        showInitialOptions();
    }

    private void showAllGames() {
        gameService.showAllGames().stream().forEach(game -> System.out.format("Game name : %-50s | Editor %-40s | Price : %-10s %n",game.getGameName(),game.getEditor(),game.getPrice()));
        System.out.println();

        showInitialOptions();
    }

    public void showAndChoose() {
        showAllGames();
        System.out.println("Enter the name of the game you want to find");
        Game game = gameService.showAndChoose(scanner.next().toLowerCase(Locale.ROOT));
        System.out.println(game.getGameName() + " " + game.getDifficulty().getDifficultyName() + " " + game.getCategory().getCategoryName());
        System.out.println("--------------------------------");
        showInitialOptions();
    }

    public void showBorrowedGames() {
        borrowService.showBorrowedGames().stream().forEach(borrow -> System.out.format("Game name : %-40s | Borrower name : %-25s | Borrow date : %-12s | return date : %-12s %n",borrow.getGame().getGameName(),borrow.getBorrower().getBorrowerName(),borrow.getBorrowDate(),borrow.getReturnDate()));

        System.out.println("Do you wish to choose a borrower by name ? ");
        System.out.println("1.search by name " +
                "\n2. Quit ");
        int choice = scanner.nextInt();
        if (choice != 1) {
            showInitialOptions();
        } else {
            searchBorrowerByName();
        }
        showInitialOptions();
    }

    private void searchBorrowerByName() {
        System.out.println("type in the name of the borrower you wish to search for ? ");
        borrowerService.searchBorrowerByName(scanner.next()).stream().forEach(borrower -> System.out.format("Borrower name : %-30s | City : %-15s | Email : %-30s | Telephone : %-15s %n",borrower.getBorrowerName(),borrower.getCity(),borrower.getEmail(),borrower.getTelephone()));
        System.out.println();
        showInitialOptions();
    }

    private void searchByDifficulty() {
        System.out.println("please select a difficulty ? " +
                "\n1. very easy " +
                "\n2. easy " +
                "\n3. average " +
                "\n4. difficult " +
                "\n5. very difficult ");
        int choice = scanner.nextInt();
        if (choice > 0 && choice < 6) {

            List<Game> gameList = gameService.searchByDifficulty(choice);
            for (Game g : gameList) {
                System.out.println(g.getGameName() + " " + g.getEditor() + " " + g.getPrice() + " " + g.getDifficulty().getDifficultyName());
                System.out.println("---------------------------------------");
            }
        } else {
            System.out.println(" error ");
        }
        showInitialOptions();
    }

    private void listStillBorrowed() {
        List<Borrow> borrowList = borrowService.listStillBorrowed();
        for (Borrow b : borrowList) {
            System.out.println(b.getGame().getGameName() + " " + b.getBorrower().getBorrowerName() + " " + b.getBorrowDate());
        }
        showInitialOptions();
    }



    private void registerNewLoan() {
        gameService.showAllGames2().stream().forEach(game -> System.out.format("Game id : %-10s | Game name : %-40s %n",game.getId(),game.getGameName()));

        System.out.println("Please enter the id of the game you want to borrow");
        int choice = scanner.nextInt();
        List<Borrow> borrowList = borrowService.listStillBorrowed();
        for (Borrow b : borrowList) {
            if (choice == b.getGame().getId()) {
                System.out.println("game already lent out ");
                showInitialOptions();
            }
        }
        Game game = gameService.findByID(choice);
        System.out.println(game.toString());
        System.out.println("--------------------");
        List<Borrower>borrowerList= borrowerService.showBorrowerList();
        for(Borrower b : borrowerList){
            System.out.println(b.getId()+" "+b.getBorrowerName());
        }
        System.out.println();
        System.out.println("Please enter the id of the borrower that wishes to borrow the game");
        int borrowerId = scanner.nextInt();
        Borrower borrower = borrowerService.findById(borrowerId);
        borrowService.updateLoan(choice,borrower);
        System.out.println("Loan registered for : " + game.getGameName() + " to : "+ borrower.getBorrowerName());

        showInitialOptions();
    }


}



