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
import snakegame.domain.Direction;

/**
 *
 * @author joelhunn
 */
public class DirectionTest {
    
    Direction direction;
    public DirectionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        direction = direction.Up;
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void movingUpTest(){
       assertEquals("You are moving Up direction", direction.printDirection());
    }
    @Test
    public void movingDownTest(){
        direction = direction.Down;
        assertEquals("You are moving Down direction", direction.printDirection());
    }
    @Test
    public void movingRightTest(){
        direction = direction.Right;
        assertEquals("You are moving Right direction", direction.printDirection());
    }
    @Test
    public void movingLeftTest(){
        direction = direction.Left;
        assertEquals("You are moving Left direction", direction.printDirection());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
