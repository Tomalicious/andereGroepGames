package com.vdab.repositories;

import com.vdab.Main;
import com.vdab.domain.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BorrowRepository {
    public List<Borrow> showBorrowedGames() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join difficulty as d on g.difficulty_id = d.id inner join borrow as b on g.id = b.game_id inner join borrower as br on b.borrower_id = br.id order by borrower_name,borrow_date");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrow> borrowList = new ArrayList<>();
            while (resultSet.next()) {
                Borrow borrow = Borrow.builder()
                        .game(Game.builder().gameName(resultSet.getString("game_name")).build())
                        .borrower(Borrower.builder().borrowerName(resultSet.getString("borrower_name")).build())
                        .borrowDate(resultSet.getDate("borrow_date"))
                        .returnDate(resultSet.getDate("return_date"))
                        .build();
                borrowList.add(borrow);
            }

            return borrowList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public List<Borrow> listStillBorrowed() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join  borrow as b on g.id = b.game_id inner join borrower as br on b.borrower_id = br.id where return_date is null");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrow> borrowList = new ArrayList<>();
            while (resultSet.next()) {
                Borrow borrow = Borrow.builder()
                        .game(Game.builder().gameName(resultSet.getString("game_name")).id(resultSet.getInt("g.id")).build())
                        .borrower(Borrower.builder().borrowerName(resultSet.getString("borrower_name")).build())
                        .borrowDate(resultSet.getDate("borrow_date"))
                        .build();
                borrowList.add(borrow);
            }

            return borrowList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public void updateLoan(int choice, Borrower borrower) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into borrow (borrow_date, return_date,game_id,borrower_id) values (sysdate(), null,? , ?) ");
            preparedStatement.setInt(1,choice );
            preparedStatement.setInt(2, borrower.getId() );
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrow> borrowList = new ArrayList<>();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

