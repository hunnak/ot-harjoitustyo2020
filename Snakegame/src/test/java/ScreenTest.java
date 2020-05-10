/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.glass.events.KeyEvent;
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
        this.screen = new Screen(20, 20);
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
   @Test
   public void snakeMoveTest() {
        Snake newSnake = new Snake(10, 10, Direction.Right);
        this.screen.setSnake(newSnake);
        this.screen.move();
        int x = this.screen.getSnake().getBodyparts().get(0).getX();
        assertEquals(x,11);
    } 
    @Test
    public void gotHurtTest() {
       assertTrue(this.screen.gameContinue());
       Snake newSnake = new Snake(10, 10, Direction.Left);
       this.screen.setSnake(newSnake);
       this.screen.move();
       this.screen.getSnake().setDirection(Direction.Down);
       this.screen.move();
       this.screen.getSnake().setDirection(Direction.Right);
       this.screen.move();
       this.screen.getSnake().setDirection(Direction.Up);
       this.screen.move();
       this.screen.gotHurt();
       assertFalse(this.screen.gameContinue());
    }
    @Test
    public void wallCollisionLeftTest() {
       assertTrue(this.screen.gameContinue());
       Snake newSnake = new Snake(10, 10, Direction.Left);
       this.screen.setSnake(newSnake);
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.outOfScreen();
       assertFalse(this.screen.gameContinue());
    }
    @Test
    public void wallCollisionDownTest() {
       assertTrue(this.screen.gameContinue());
       Snake newSnake = new Snake(10, 10, Direction.Down);
       this.screen.setSnake(newSnake);
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.outOfScreen();
       assertFalse(this.screen.gameContinue());
    }
    @Test
    public void wallCollisionUpTest() {
       assertTrue(this.screen.gameContinue());
       Snake newSnake = new Snake(10, 10, Direction.Up);
       this.screen.setSnake(newSnake);
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.outOfScreen();
       assertFalse(this.screen.gameContinue());
    }
        @Test
    public void wallCollisionRightTest() {
       assertTrue(this.screen.gameContinue());
       Snake newSnake = new Snake(10, 10, Direction.Right);
       this.screen.setSnake(newSnake);
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.move();
       this.screen.outOfScreen();
       assertFalse(this.screen.gameContinue());
    } 
    @Test
    public void getWidthTest() {
        assertEquals(this.screen.getW(),20);
    }
    @Test
    public void getHeigthTest() {
        assertEquals(this.screen.getH(),20);
    }
    @Test
    public void getScoresTest() {
        assertEquals(this.screen.getScores(), 0);
    }

    
}
