package dwbe.lojatenis.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static Connection connection;

    public static Connection getConnection(){
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-MGQG2VE;database=db_lojatenis;", "sa", "loja1");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return connection;
    }
}
