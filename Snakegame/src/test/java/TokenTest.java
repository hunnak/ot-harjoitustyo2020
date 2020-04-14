/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakegame.domain.Token;

/**
 *
 * @author joelhunn
 */
public class TokenTest {
    
    
    Token token;
    Token newToken;
    
    public TokenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        token = new Token(10,12);
        newToken = new Token(10,10);
    }
    
    @After
    public void tearDown() {
    }
    

    @Test
    public void constructorIsRightTest() {
        assertEquals("(10,12)", token.toString());
        
    }
    @Test
    public void getXTest() {
        assertEquals(10,token.getX());
    }
    @Test
    public void getYTest() {
        assertEquals(12,token.getY());
    }
    @Test
    public void booleanTouchTest() {
        assertTrue(token.touch(token));
        assertFalse(token.touch(newToken));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
