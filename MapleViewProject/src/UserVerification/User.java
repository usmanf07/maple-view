/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserVerification;
import static UserVerification.SignupVerification.con;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import sqlCon.ConnectionUtil;
/**
 *
 * @author usman
 */
public class User 
{
    public int userID;
    public String userName;
    private String password;
    public String email;
    public int userType;
    public static User currentUser;
    static Connection con = null;
    static PreparedStatement ps = null;
    
    public User(int userID, String name, String email, String password, int userType) 
    {
        this.userID = userID;
        this.userName = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
    
    public static String updateMembership()
    {
        String result = "success";
        if(con == null)
            con = ConnectionUtil.conDB();
        String query = "update User set userType = 2 where userId = ?";
        
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, currentUser.userID);
            int check = ps.executeUpdate();
            if(check == 1){
                currentUser.userType = 2;
                return result;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return result;
    }
}
