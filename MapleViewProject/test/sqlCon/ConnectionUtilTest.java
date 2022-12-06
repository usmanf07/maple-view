/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package sqlCon;

import java.sql.Connection;
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
public class ConnectionUtilTest {
    
    
    /**
     * Test of conDB method, of class ConnectionUtil.
     */
    @Test
    public void testSQLCOnnection() 
    {
        Connection con = ConnectionUtil.conDB();
        assertNotNull(con);
    }
    
}
