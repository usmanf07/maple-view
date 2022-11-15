/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserVerification;

import static UserVerification.LoginVerification.con;
import static UserVerification.LoginVerification.preparedStatement;
import static UserVerification.LoginVerification.resultSet;
import static UserVerification.User.currentUser;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sqlCon.ConnectionUtil;

/**
 *
 * @author usman
 */
public class SignupVerification {
    static Connection con = null;
    static CallableStatement cs = null;
    static ResultSet resultSet = null;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    
    public static String verifySignup(String email, String password, String cnfrmPassword, String userName)
    {
           String result = "success";
        
        if(con == null)
            con = ConnectionUtil.conDB();
        
            if(email.isEmpty() || password.isEmpty() || cnfrmPassword.isEmpty() || userName.isEmpty()) {
               return result = "You cannot leave any field empty!";
            }
            
            if(!password.equals(cnfrmPassword))
                return result = "The confirmation password is not same!";
            
            if(password.length() < 6)
                return result = "Password length must be greater than 6!";
            
            if(!validateEmail(email))
            {
                return result = "Invalid email entered!";
            }
            
            int userType = 1; //Non-premium User
            String sql = "call SignUp(?, ?, ?, ?, ?);";
            try 
            {
                String uid = "";
                cs = (CallableStatement) con.prepareCall(sql);
                cs.setString(1, userName);
                cs.setString(2, email);
                cs.setString(3, password);
                cs.setInt(4, userType);
                cs.registerOutParameter(5, java.sql.Types.VARCHAR);
                cs.executeUpdate();
            
                uid = cs.getString(5);
                if(uid.equals("duplicate"))
                     return result = "Email Already Exists!";
                else
                    currentUser = new User(Integer.valueOf(uid), userName, email, password, userType);

                con = null;
                cs = null;
                resultSet = null;
                
            }
            catch (SQLException ex) {
                System.out.println("Error Occured: " + ex);
                return result = "\t\tException";
            }
     
            return result;
    }
}
