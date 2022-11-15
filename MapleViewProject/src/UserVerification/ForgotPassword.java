/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UserVerification;

import static UserVerification.LoginVerification.con;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import javax.mail.Authenticator;
import javax.mail.internet.*;
import javax.activation.*;
import javax.mail.Session;
import javax.mail.Transport;
import sqlCon.ConnectionUtil;
/**
 *
 * @author usman
 */
public class ForgotPassword {
    static Connection con = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;
     public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static boolean validateEmail(String emailStr) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }
    public static String forgotPass(String email)
    {
           String result = "success";
           if(email.isEmpty())
               return result = "Empty Mail Field!";
        
               
           if(!validateEmail(email))
                return result = "Invalid mail entered!";
           if(con == null)
                con = ConnectionUtil.conDB();
           String query = "select * from User where email = ?";
           try
           {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, email);
                resultSet = preparedStatement.executeQuery();
                
                if (resultSet.next()) 
                {
                    String password = resultSet.getString("password");
                    String recipient = email;
                    String name = resultSet.getString("name");
                    if(sendMail(recipient, password, name))
                        return result;
                    else
                        return result = "An smtp server error occured!";
                }
                else
                {
                    return result;
                }
           }
           
           catch (SQLException ex) {
                  return result = ex.getMessage();
            }
    }
    
    public static boolean sendMail(String recMail, String recPass, String recName)
    {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String mail = "mapleviewcsr@gmail.com";
        String password = "ixjopgkdtuaqblao";
        
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication (mail, password);
            }
        });
        Message message = prepareMessage(session, mail, password, recMail, recPass, recName);
        try {
            Transport.send(message);
            return true;
        } catch (MessagingException ex) {
             System.err.println(ex);
        }
        return false;
    }
    
    private static Message prepareMessage(Session session, String mail, String password, String recMail, String recPass, String recName) {
        try
        {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(mail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recMail));
            message.setSubject("MapleView: Password Reset");
            message.setText("Hey " + recName + "," + "\n Your password for MapleView is: " + recPass + "\nRegards,\n MapleView CSR");
            return message;
        }
        catch(Exception ex)
        {
            System.err.println(ex);
        }
        return null;
    }
}
