/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakegame.domain.Direction;
import snakegame.domain.Point;
import snakegame.domain.Snake;

/**
 *
 * @author joelhunn
 */
public class SnakeTest {
    Snake snake;
    
    public SnakeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        snake= new Snake(10, 10, Direction.Left);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    
    @Test
    public void beginGetHeadSnakeTest() {
        ArrayList<Point> list = new ArrayList<Point>();
        Point point = new Point(10, 10);
        list.add(point);
        Assert.assertEquals(list, snake.getBodyparts());
        
    }
    @Test
    public void getDirectionTest() {
        assertEquals("You are moving Left direction", snake.getDirection().printDirection());
    }
    @Test
    public void setDirectionTest() {
        snake.setDirection(Direction.Down);
        assertEquals("You are moving Down direction", snake.getDirection().printDirection());
        
    }
    @Test
    public void snakelenghtTest() {
        assertEquals(1, snake.getSnakeLenght());
        
    }
    @Test
    public void snakeGrowTest() {
        assertFalse(snake.grow);
        snake.grow();
        assertTrue(snake.grow);
    }
}
