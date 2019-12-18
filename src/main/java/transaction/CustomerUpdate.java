package transaction;

import mappers.CustomerMapper;
import models.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerUpdate {

    public static void doRollback(Connection connection, String last_name, String email) throws SQLException {
        connection.setAutoCommit(false);

        Customer beforeUpdateCust = getCustomer(connection, last_name);

        if (beforeUpdateCust.getActive() == 0) {
            connection.rollback();
            System.out.println("Customer inactive, transaction rollbacked.");
        } else {
            updateEmail(connection, last_name, email);
            connection.commit();
            System.out.println("Customer's email updated. ");
        }
    }

    public static void updateEmail(Connection connection, String last_name, String email) throws SQLException {
        System.out.println("Updating email...");
        String updateQuery = "UPDATE customer SET email = ? WHERE last_name = ?";
        PreparedStatement statement = connection.prepareStatement(updateQuery);
        statement.setString(1, email);
        statement.setString(2, last_name);
    }

    public static Customer getCustomer(Connection connection, String last_name) throws SQLException {
        System.out.println("Getting customer data: ");
        String temp = "SELECT * FROM customer WHERE last_name = ?";

        PreparedStatement statement = connection.prepareStatement(temp);
        statement.setString(1, last_name);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Customer customer = CustomerMapper.map(resultSet);
        statement.close();
        System.out.println(customer);
        return customer;
    }
}