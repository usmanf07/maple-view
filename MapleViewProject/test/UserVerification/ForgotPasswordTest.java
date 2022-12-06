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
public class ForgotPasswordTest {
    /**
     * Test of forgotPass method, of class ForgotPassword.
     */
    @Test
    public void testValidEmailForgotPass() 
    {
        String email = "gamerobuddy@gmail.com";
        String expResult = "success";
        String result = ForgotPassword.forgotPass(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvalidEmailForgotPass() 
    {
        String email = "invalid@gmail.com";
        String expResult = "notexist";
        String result = ForgotPassword.forgotPass(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEmptyEmailForgotPass() 
    {
        String email = "";
        String expResult = "Empty Mail Field!";
        String result = ForgotPassword.forgotPass(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testOtherDomainForgotPass() 
    {
        String email = "usman-faisal1@hotmail.com";
        String expResult = "success";
        String result = ForgotPassword.forgotPass(email);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testInvalidFormatForgotPass() 
    {
        String email = "111111";
        String expResult = "Invalid mail entered!";
        String result = ForgotPassword.forgotPass(email);
        assertEquals(expResult, result);
    }
}
