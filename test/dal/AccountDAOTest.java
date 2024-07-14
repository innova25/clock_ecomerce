/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dal;

import java.util.List;
import model.account;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author admin
 */
public class AccountDAOTest {
    
    public AccountDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllClient method, of class AccountDAO.
     */
    @Test
    public void testGetAllClient() {
        System.out.println("getAllClient");
        AccountDAO instance = new AccountDAO();
        List<account> expResult = null;
        List<account> result = instance.getAllClient();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLogin method, of class AccountDAO.
     */
    @Test
    public void testCheckLogin() {
        System.out.println("checkLogin");
        String user = "";
        String pass = "";
        AccountDAO instance = new AccountDAO();
        account expResult = null;
        account result = instance.checkLogin(user, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkLoginAdmin method, of class AccountDAO.
     */
    @Test
    public void testCheckLoginAdmin() {
        System.out.println("checkLoginAdmin");
        String user = "";
        String pass = "";
        AccountDAO instance = new AccountDAO();
        account expResult = null;
        account result = instance.checkLoginAdmin(user, pass);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserClient method, of class AccountDAO.
     */
    @Test
    public void testCheckUserClient() {
        System.out.println("checkUserClient");
        String user = "";
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.checkUserClient(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkUserAdmin method, of class AccountDAO.
     */
    @Test
    public void testCheckUserAdmin() {
        System.out.println("checkUserAdmin");
        String user = "";
        AccountDAO instance = new AccountDAO();
        boolean expResult = false;
        boolean result = instance.checkUserAdmin(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addClient method, of class AccountDAO.
     */
    @Test
    public void testAddClient() {
        System.out.println("addClient");
        String user = "";
        String pass = "";
        String name = "";
        String phone = "";
        String email = "";
        String address = "";
        AccountDAO instance = new AccountDAO();
        String expResult = "";
        String result = instance.addClient(user, pass, name, phone, email, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addAdmin method, of class AccountDAO.
     */
    @Test
    public void testAddAdmin() {
        System.out.println("addAdmin");
        String user = "";
        String pass = "";
        String name = "";
        String phone = "";
        String email = "";
        String address = "";
        AccountDAO instance = new AccountDAO();
        String expResult = "";
        String result = instance.addAdmin(user, pass, name, phone, email, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByUsername method, of class AccountDAO.
     */
    @Test
    public void testFindByUsername() {
        System.out.println("findByUsername");
        String user = "";
        AccountDAO instance = new AccountDAO();
        account expResult = null;
        account result = instance.findByUsername(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateInfo method, of class AccountDAO.
     */
    @Test
    public void testUpdateInfo() {
        System.out.println("updateInfo");
        String user = "";
        String pass = "";
        String name = "";
        String phone = "";
        String email = "";
        String address = "";
        AccountDAO instance = new AccountDAO();
        String expResult = "";
        String result = instance.updateInfo(user, pass, name, phone, email, address);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteUserById method, of class AccountDAO.
     */
    @Test
    public void testDeleteUserById() {
        System.out.println("deleteUserById");
        int id = 0;
        AccountDAO instance = new AccountDAO();
        String expResult = "";
        String result = instance.deleteUserById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
