package com.vdab.repositories;

import com.vdab.Main;
import com.vdab.domain.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameRepository {

    private final String baseQuery = "select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id ";


    public Game findFifthGame() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery + "where g.id = 5 ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder in game object
            return createGameObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Game findGameByPartName(String string) throws NotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery+" where LOWER(game_name) LIKE ? ");
            preparedStatement.setString(1,"%"+string+"%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return createGameObject(resultSet);
        } catch (Exception e) {
          throw new NotFoundException("no such game");
        }
    }

    public List<Game> showAllGames() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery+ " order by game_name ");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList =new ArrayList<>();
            while (resultSet.next()){
                gameList.add(createGameObject((resultSet)));
            }
            return gameList;

        } catch (Exception e) {
           e.printStackTrace();
           return null;
        }
    }

    public List<Game> showAllGames2() {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from game as g inner join category as c on g.category_id = c.id inner join difficulty as d on g.difficulty_id = d.id");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList =new ArrayList<>();
            while (resultSet.next()){
                gameList.add((createGameObject((resultSet))));
            }
            // dit is wat we gaan oproepen via builder
            return gameList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Game showAndChoose(String string) throws NotFoundException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery+"where game_name LIKE ?");
            preparedStatement.setString(1,"%"+string+"%");
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            // dit is wat we gaan oproepen via builder
        resultSet.next();
        return  createGameObject(resultSet);
        } catch (Exception e) {
           throw new NotFoundException("invalid");
        }
    }

    public List<Game> searchByDifficulty(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery + "where d.id >=?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Game>gameList=new ArrayList<>();
            while(resultSet.next()){
                gameList.add(createGameObject((resultSet)));

            }
            return gameList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public Game findByID(int id) {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games","root","P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement(baseQuery+" where g.id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            // dit is wat we gaan oproepen via builder
            return createGameObject(resultSet);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private  Game createGameObject(ResultSet resultSet) throws SQLException{
        return Game.builder().id(resultSet.getInt("g.id"))
                .gameName(resultSet.getString("game_name"))
                .editor(resultSet.getString("editor"))
                .author(resultSet.getString("author"))
                .age(resultSet.getString("age"))
                .yearEdition(resultSet.getInt("year_edition"))
                .minPlayers(resultSet.getInt("min_players"))
                .maxPlayers(resultSet.getInt("max_players"))
                .category(new Category(resultSet.getInt("c.id"),resultSet.getString("category_name")))
                .playDuration(resultSet.getString("play_duration"))
                .difficulty(new Difficulty(resultSet.getInt("d.id"), resultSet.getString("difficulty_name")))
                .price(resultSet.getDouble("price"))
                .image(resultSet.getString("image"))
                .build();
    }

    public void save(Game newGame, Category newCategory, Difficulty newDifficulty) throws SQLException {

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "P@ssw0rd")) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into game (game_name, editor , author, year_edition, age , min_players , max_players , play_duration , price , category_id , difficulty_id) values (?,?,?,?,?,?,?,?,?, ? ,?) ");
            preparedStatement.setString(1, newGame.getGameName() );
            preparedStatement.setString(2, newGame.getEditor() );
            preparedStatement.setString(3, newGame.getAuthor() );
            preparedStatement.setInt(4, newGame.getYearEdition() );
            preparedStatement.setString(5, newGame.getAge() );
            preparedStatement.setInt(6, newGame.getMinPlayers() );
            preparedStatement.setInt(7, newGame.getMaxPlayers() );
            preparedStatement.setString(8, newGame.getPlayDuration() );
            preparedStatement.setDouble(9, newGame.getPrice() );
            preparedStatement.setInt(10, newCategory.getId() );
            preparedStatement.setInt(11, newDifficulty.getId() );

            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Borrow> borrowList = new ArrayList<>();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
