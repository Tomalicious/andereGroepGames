package com.vdab.repositories;

import com.vdab.domain.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CategoryRepository {

    public Category findCategoryOne() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category where id = 1 ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();

            // dit is wat we gaan oproepen via builder
            return Category.builder().id(resultSet.getInt("id")).categoryName(resultSet.getString("category_name")).build();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
