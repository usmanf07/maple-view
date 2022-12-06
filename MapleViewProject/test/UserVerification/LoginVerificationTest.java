/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package UserVerification;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author usman
 */
public class LoginVerificationTest {
    
    @Test
    public void testValidLogin() 
    {
        String email = "1@1.com";
        String password = "1";
        String expResult = "success";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInValidUserLogin() 
    {
        String email = "invalid@gmail.com";
        String password = "1";
        String expResult = "Enter Correct Email/Password";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void InvalidEmailFormat1() 
    {
        String email = "my";
        String password = "1";
        String expResult = "Invalid email entered!";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
    
     @Test
    public void InvalidEmailFormat2() 
    {
        String email = "my@my";
        String password = "1";
        String expResult = "Invalid email entered!";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyEmail() 
    {
        String email = "";
        String password = "1";
        String expResult = "Empty credentials";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyPassword() 
    {
        String email = "1@1";
        String password = "";
        String expResult = "Empty credentials";
        String result = LoginVerification.verifyLogin(email, password);
        assertEquals(expResult, result);
    }
}
