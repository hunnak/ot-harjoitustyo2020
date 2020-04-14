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
import snakegame.domain.Point;

/**
 *
 * @author joelhunn
 */
public class PointTest {
    
    Point point;
    Point touchpoint;
    
    public PointTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        point = new Point(10,12);
        touchpoint = new Point(10,10);
    }
    
    @After
    public void tearDown() {
    }
    

    @Test
    public void constructorIsRightTest() {
        assertEquals("(10,12)", point.toString());
        
    }
    @Test
    public void getXTest() {
        assertEquals(10,point.getX());
    }
    @Test
    public void getYTest() {
        assertEquals(12,point.getY());
    }
    @Test
    public void booleanTouchTest() {
        assertTrue(point.touch(point));
        assertFalse(point.touch(touchpoint));
    }
    


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
