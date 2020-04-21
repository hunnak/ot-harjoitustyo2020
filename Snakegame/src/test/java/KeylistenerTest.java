/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import snakegame.domain.Direction;
import snakegame.domain.Keylistener;
import snakegame.domain.Snake;

/**
 *
 * @author joelhunn
 */
public class KeylistenerTest {
    Keylistener listener;
    Robot robot;
    Snake snake;
    public KeylistenerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws AWTException {
        listener = new Keylistener(new Snake(10,10,Direction.Left));
        this.robot = null; 
       
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void keypressingUpTest() throws AWTException {
        //KeyEvent event = new KeyEvent(VK_UP);
        this.robot = new Robot();
        robot.keyPress(KeyEvent.VK_UP);
        assertEquals(snake.getDirection(), Direction.Up);
    }
        
        
    
}
