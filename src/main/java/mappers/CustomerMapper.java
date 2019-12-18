package mappers;

import models.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper {

    public static Customer map(ResultSet resultSet) throws SQLException {
        Customer customer = new Customer();

        customer.setCustomer_id(resultSet.getInt("customer_id"));
        customer.setFirst_name(resultSet.getString("first_name"));
        customer.setLast_name(resultSet.getString("last_name"));
        customer.setActive(resultSet.getInt("active"));

        return customer;
    }

}
