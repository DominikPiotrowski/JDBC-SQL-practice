package mappers;

import models.Film;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmMapper {
    public static Film map(ResultSet resultSet) throws SQLException {
        Film film = new Film();

      //  film.setFilm_id(resultSet.getInt(1));
        film.setTitle(resultSet.getString(1));
        film.setDescription(resultSet.getString(2));
       // film.setRelease_year(resultSet.getInt(4));
       // film.setLanguage_id(resultSet.getInt(5));
      //  film.setOriginal_language_id(resultSet.getInt(6));
      //  film.setRental_duration(resultSet.getInt(7));
       // film.setRental_rate(resultSet.getFloat(8));
      //  film.setLenght(resultSet.getInt(9));
      //  film.setReplacement_cost(resultSet.getFloat(10));
      // film.setRating(resultSet.getString(3));
      //  film.setSpecial_features(resultSet.getString(12));
      //  film.setLast_update(resultSet.getTimestamp(13));

        return film;
    }
}