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
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/mapleview?autoReconnect=true", "root", "18august");
            if(con != null)
                    return con;           
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error: "+ ex.getMessage());
           
        }
            return null;
    }

}
