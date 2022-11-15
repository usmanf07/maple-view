/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserVerification;
import java.sql.*;
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
    
    public User(int userID, String name, String email, String password, int userType) 
    {
        this.userID = userID;
        this.userName = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }
}
