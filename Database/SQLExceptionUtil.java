package dwbe.lojatenis.Util;

import java.sql.SQLException;

public class SQLExceptionUtil {
    public static void handleSQLException(SQLException e) {
        System.out.println(e.getMessage());
    }
}
