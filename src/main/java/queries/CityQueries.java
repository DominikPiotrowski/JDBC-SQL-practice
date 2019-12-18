package queries;

import mappers.CityMapper;
import models.City;

import java.sql.*;

public class CityQueries {

    public static void citiesInAlphabeticOrder(Connection connection) throws SQLException {
        String query = "SELECT city.city FROM city ORDER BY city ASC";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String result = resultSet.getString("city");
            System.out.printf(result + "\n");
        }
    }

    public static void getCitiesByCountry(Connection connection, String countryName) throws SQLException {
        String query = "SELECT sakila.city.*, sakila.country.* FROM sakila.city " +
                "INNER JOIN sakila.country ON sakila.country.country_id=sakila.city.country_id " +
                "WHERE sakila.country.country = ?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, countryName);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            City city = CityMapper.map(resultSet);
            System.out.println(city.toString());
        }
    }

    public static void getCountryByCity(Connection connection, String city) {
        //TODO
    }
}
