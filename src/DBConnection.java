import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection{

    private static final String URL = "jdbc:mysql://localhost:3306/student_management";
    private static final String USER = System.getenv("DB_USER");
    private static final String PASSWORD = System.getenv("DB_PASSWORD");

    public static Connection getConnection() throws SQLException {
        if (USER == null || PASSWORD == null) {
            throw new IllegalStateException(
                    "Set the DB_USER and DB_PASSWORD environment variables."
            );
        }

        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}