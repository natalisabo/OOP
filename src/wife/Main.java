package wife;

import java.sql.Connection;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;
import wife.MySQLJDBCUtil;
/**
 *
 * @author mysqltutorial.org
 */
public class Main {
    public static Statement stmt;
    public static void main(String[] args) {
        String sql = "SELECT * " + "FROM grocary";
        // create a new connection from MySQLJDBCUtil
        try (Connection conn = MySQLJDBCUtil.getConnection();
            Statement stmt  = conn.createStatement();
            ResultSet rs    = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println(rs.getString("Product_name") + "\t" +
                        rs.getString("Product_price"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
