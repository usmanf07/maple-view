/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sqlCon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author usman
 */
public class ConnectionUtil {

    Connection conn = null;
    public static Connection conDB()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://db-mysql-nyc1-31358-do-user-11554933-0.b.db.ondigitalocean.com:25060/defaultdb?zeroDateTimeBehavior=CONVERT_TO_NULL", "doadmin", "AVNS_VhipCjdhVBYik_nUvM9");
            if(con != null)
                    return con;           
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error: "+ ex.getMessage());
           
        }
            return null;
    }

}
