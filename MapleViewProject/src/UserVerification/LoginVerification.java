/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserVerification;
import static UserVerification.SignupVerification.VALID_EMAIL_ADDRESS_REGEX;
import static UserVerification.SignupVerification.validateEmail;
import static UserVerification.User.currentUser;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import sqlCon.ConnectionUtil;

/**
 *
 * @author usman
 */
public class LoginVerification 
{
    static Connection con = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validateEmail(String emailStr) 
    {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static String verifyLogin(String email, String password)
    {
           String result = "success";
        
        if(con == null)
            con = ConnectionUtil.conDB();
        
        if(email.isEmpty() || password.isEmpty()) {
            return result = "Empty credentials";
        }
        if(!validateEmail(email))
        {
            return result = "Invalid email entered!";
        }
        
        else{
            String name; 
            int userID, userType;
            
            String query = "select * from User where email = ? and password = ?";
            try {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, email);
                preparedStatement.setString(2, password);
                resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) 
                {
                    userID = resultSet.getInt("userId");
                    name = resultSet.getString("name");
                    userType = resultSet.getInt("userType");
                    
                    currentUser = new User(userID, name, email, password, userType);
                    con = null;
                    preparedStatement = null;
                    resultSet = null;
                }
                else{
                    return result = "Enter Correct Email/Password";
                }
            }
            catch (SQLException ex) {
                  return result = ex.getMessage();
            }
        }
        
        return result;
    }
}
