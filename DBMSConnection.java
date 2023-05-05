package tp5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBMSConnection  {
    private static String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static String driver = "oracle.jdbc.driver.OracleDriver";
    private static String user = "SYSTEM";
    private static String password = "system";

    private static Connection con;

    public DBMSConnection() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Connection getConnection() {
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    
    }
}
