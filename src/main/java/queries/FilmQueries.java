package queries;

import mappers.FilmMapper;
import models.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmQueries {

    public static void getFilmByRating(Connection connection, String rating) throws SQLException {
        String query = "SELECT title, description FROM film WHERE rating = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, rating);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Film film = FilmMapper.map(resultSet);
            System.out.printf(film.getTitle() + ": " + film.getDescription() + "\n");
        }
        statement.close();
    }
}
