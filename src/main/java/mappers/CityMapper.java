package mappers;

import models.City;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityMapper {

    public static City map(ResultSet resultSet) throws SQLException {
        City city = new City();

        city.setCity_id(resultSet.getInt(1));
        city.setCity(resultSet.getString(2));
        city.setCountry_id(resultSet.getInt(3));
        city.setLast_update(resultSet.getTimestamp(4));

        return city;
    }

}
