import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {

    public static Connection establishConnection() throws SQLException {

        Properties connectionPropert = new Properties();
        connectionPropert.put("user", "root");
        connectionPropert.put("password", "#######");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila?serverTimezone=GMT&&useSSL=false",
                connectionPropert);
    }
}