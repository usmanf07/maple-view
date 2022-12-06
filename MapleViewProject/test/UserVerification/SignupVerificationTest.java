/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UserVerification;

import static UserVerification.LoginVerification.con;
import static UserVerification.LoginVerification.preparedStatement;
import static UserVerification.LoginVerification.resultSet;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sqlCon.ConnectionUtil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usman
 */
public class SignupVerificationTest 
{
    /**
     * Test of verifySignup method, of class SignupVerification.
     */
    @Test
    public void testValidSignup() 
    {
        String email = "new@gmail.com";
        String password = "123456";
        String cnfrmPassword = "123456";
        String userName = "usman";
        String expResult = "success";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
        Connection con = ConnectionUtil.conDB();
        String query = "Delete from User where email = \'new@gmail.com\'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SignupVerificationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testInValidEmailSignup() 
    {
        String email = "newgmail.com";
        String password = "123456";
        String cnfrmPassword = "123456";
        String userName = "usman";
        String expResult = "Invalid email entered!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInValidPasswordSignup() 
    {
        String email = "new@gmail.com";
        String password = "123";
        String cnfrmPassword = "123";
        String userName = "usman";
        String expResult = "Password length must be greater than 6!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDuplicateEmailSignup() 
    {
        String email = "new@gmail.com";
        String password = "123456";
        String cnfrmPassword = "123456";
        String userName = "usman";

        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        
        email = "new@gmail.com";
        password = "123456";
        cnfrmPassword = "123456";
        userName = "usman";
        String expResult = "Email Already Exists!";
        result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        
        assertEquals(expResult, result);
        Connection con = ConnectionUtil.conDB();
        String query = "Delete from User where email = \'new@gmail.com\'";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SignupVerificationTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testNotSamePasswordSignup() 
    {
        String email = "new@gmail.com";
        String password = "123456";
        String cnfrmPassword = "7891022";
        String userName = "usman";
        String expResult = "The confirmation password is not same!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyEmailSignup() 
    {
        String email = "";
        String password = "123456";
        String cnfrmPassword = "123456";
        String userName = "usman";
        String expResult = "You cannot leave any field empty!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyPasswordSignup() 
    {
        String email = "new@gmail.com";
        String password = "";
        String cnfrmPassword = "123456";
        String userName = "usman";
        String expResult = "You cannot leave any field empty!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyCnfrmPasswordSignup() 
    {
        String email = "new@gmail.com";
        String password = "123456";
        String cnfrmPassword = "";
        String userName = "usman";
        String expResult = "You cannot leave any field empty!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyNameSignup() 
    {
        String email = "new@gmail.com";
        String password = "123456";
        String cnfrmPassword = "123456";
        String userName = "";
        String expResult = "You cannot leave any field empty!";
        String result = SignupVerification.verifySignup(email, password, cnfrmPassword, userName);
        assertEquals(expResult, result);
    }
}
