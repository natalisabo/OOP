package wife;

import java.sql.Connection;
import java.sql.SQLException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MySQLJDBCUtil {

    /**
     * Get database connection
     *
     * @return a Connection object
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;

        try (FileInputStream f = new FileInputStream("D://dogs_db")) {

            // load the properties file
            String url       = "jdbc:mysql://127.0.0.1:3306/dogs_db";
            String user      = "root";
            String password  = "root";
            Class.forName("com.mysql.jdbc.Driver");
            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        }catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return conn;
    }

}