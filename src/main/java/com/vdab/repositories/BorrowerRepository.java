package com.vdab.repositories;

import com.vdab.Main;
import com.vdab.domain.Borrow;
import com.vdab.domain.Borrower;
import com.vdab.domain.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BorrowerRepository {

    public Borrower findInfoBorrower() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower where id = 1 ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder
            return Borrower.builder().borrowerName(resultSet.getString("borrower_name")).city(resultSet.getString("city")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Borrower> searchBorrowerByName(String string) throws NotFoundException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower where (borrower_name) LIKE ?");
            preparedStatement.setString(1,"%"+string+"%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrower>borrowerList = new ArrayList<>();
            while(resultSet.next()){
                Borrower borrower = Borrower.builder()
                        .borrowerName(resultSet.getString("borrower_name"))
                        .city(resultSet.getString("city"))
                        .busNumber(resultSet.getString("bus_number"))
                        .email(resultSet.getString("email"))
                        .houseNumber(resultSet.getString("house_number"))
                        .postalCode(resultSet.getString("postcode"))
                        .street(resultSet.getString("street"))
                        .telephone(resultSet.getString("telephone"))
                        .id(resultSet.getInt("id"))
                        .build();
                borrowerList.add(borrower);

            }
            if(borrowerList.isEmpty()) {
                throw new NotFoundException("there is no such borrower");
            }
            return borrowerList;
        } catch (Exception e) {
            throw new NotFoundException("there is no such borrower");
        }

    }

    public List<Borrower> showBorrowerList() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrower>borrowerList=new ArrayList<>();
            while(resultSet.next()){
                Borrower borrower = Borrower.builder()
                        .id(resultSet.getInt("id"))
                        .borrowerName(resultSet.getString("borrower_name"))
                        .build();
                borrowerList.add(borrower);
            }
            return borrowerList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Borrower findById(int borrowerId) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from borrower where id = ?");
            preparedStatement.setInt(1,borrowerId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
                Borrower borrower = Borrower.builder()
                        .borrowerName(resultSet.getString("borrower_name"))
                        .city(resultSet.getString("city"))
                        .busNumber(resultSet.getString("bus_number"))
                        .email(resultSet.getString("email"))
                        .houseNumber(resultSet.getString("house_number"))
                        .postalCode(resultSet.getString("postcode"))
                        .street(resultSet.getString("street"))
                        .telephone(resultSet.getString("telephone"))
                        .id(resultSet.getInt("id"))
                        .build();
            return borrower;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
