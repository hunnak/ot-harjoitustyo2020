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
import snakegame.domain.Screen;
import snakegame.domain.Snake;
import snakegame.domain.Direction;
import snakegame.domain.Update;

/**
 *
 * @author joelhunn
 */
public class ScreenTest {
    Screen screen;
    public ScreenTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.screen = new Screen(600, 600);
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void snakeTest() {
        Snake newSnake = new Snake(10, 10, Direction.Right);
        this.screen.setSnake(newSnake);
        assertEquals(screen.getSnake(), newSnake);
        
    }
   /* @Test
   * public void snakeMoveTest() {
        Snake newSnake = new Snake(10, 10, Direction.Right);
        this.screen.setSnake(newSnake);
        this.screen.getSnake().move();
        this.screen.getSnake().getBodyparts().get(0);
    
        
    }    
    */    
}
