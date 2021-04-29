package com.vdab.repositories;

import com.vdab.domain.Borrower;
import com.vdab.domain.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
