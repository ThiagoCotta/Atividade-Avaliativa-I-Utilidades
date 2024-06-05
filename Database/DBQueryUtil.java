package dwbe.lojatenis.Util;

import java.sql.*;

public class DBQueryUtil {

    public static void executeUpdate(String sql, SQLConsumer<PreparedStatement> consumer) throws SQLException {
        try (PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            consumer.accept(pstmt);
            pstmt.executeUpdate();
        }
    }

    public static ResultSet executeQuery(String sql, SQLConsumer<PreparedStatement> consumer) throws SQLException {
        PreparedStatement pstmt = DatabaseConnection.getConnection().prepareStatement(sql);
        consumer.accept(pstmt);
        return pstmt.executeQuery();
    }

    @FunctionalInterface
    public interface SQLConsumer<T> {
        void accept(T t) throws SQLException;
    }
}
