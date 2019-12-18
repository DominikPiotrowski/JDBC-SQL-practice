package queries;

import mappers.ActorMapper;
import models.Actor;

import java.sql.*;

public class ActorQueries {

    public static void showAny10Actors(Connection connection) throws SQLException {

        String query = "SELECT * FROM actor LIMIT 10";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actorsNames = resultSet.getString("first_name");
            String actorsLastNames = resultSet.getString("last_name");
            System.out.printf(actorsNames + " " + actorsLastNames + "\n");
        }
        statement.close();
    }

    public static void actorsInAlphabeticalOrder(Connection connection) throws SQLException {
        String query = "SELECT actor FROM actor ORDER BY actor ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String result = resultSet.getString("actor");
            System.out.println(result + "\n");
        }
    }

    public static void showActorsNameZero(Connection connection) throws SQLException {

        String query = "SELECT * FROM actor WHERE first_name = 'ZERO'";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String actorsFirstNames = resultSet.getString("first_name");
            String actorsLastNames = resultSet.getString("last_name");
            System.out.printf(actorsFirstNames + " " + actorsLastNames + "\n");
        }
        statement.close();
    }

    public static void countActorsByName(Connection connection, String name) throws SQLException {
        String query = "SELECT COUNT(*) FROM actor WHERE actor.first_name = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int numOfActorsNameEd = resultSet.getInt(1);
            System.out.printf("Number of actors named " + name + ": " + numOfActorsNameEd + "\n");
        }
        statement.close();
    }

    public static void showActorByGivenFirstName(Connection connection, String name) throws SQLException {
        System.out.println("Requested actor data: ");
        String query = "SELECT * FROM actor WHERE first_name = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, name);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Actor actor = ActorMapper.map(resultSet);
            System.out.println(actor.toString());
        }
        statement.close();
    }

    public static void showActorsUpdatedInGivenTime(Connection connection, Timestamp before, Timestamp after) throws SQLException {

        String query = "SELECT * FROM actor WHERE last_update > ? AND last_update < ? ";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setTimestamp(1, before);
        statement.setTimestamp(2, after);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Actor actor = ActorMapper.map(resultSet);
            System.out.printf(actor.toString());
        }
        statement.close();
    }

    public static void uppdateActorFirstNameByGivenLastName(Connection connection, String firstName, String lastName) throws SQLException {
        String query = "UPDATE actor SET first_name = ? WHERE last_name = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, firstName);
        statement.setString(2, lastName);
        statement.executeUpdate();
        System.out.println("Name of actor with first name: " + lastName + "updated to" + firstName);

        statement.close();
    }

    public static void deleteActor(Connection connection, String firstName, String lastName) throws SQLException {
            String query = "DELETE FROM actor WHERE first_name = ? AND last_name = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, firstName);
            statement.setString(2, lastName);

            if (statement.executeUpdate() != 0) {
                System.out.println(firstName + " " + lastName + " deleted.");
            } else {
                System.out.println("No such actor in database");
            }
    }
}