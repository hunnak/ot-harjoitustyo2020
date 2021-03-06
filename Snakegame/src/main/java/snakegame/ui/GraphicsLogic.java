/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snakegame.domain.Point;
import snakegame.domain.Screen;
import snakegame.domain.Screen;
import snakegame.domain.Snake;
import snakegame.domain.Token;
import snakegame.domain.Update;

/**
 *
 * @author joelhunn
 */
public class GraphicsLogic extends JPanel implements Update {

    private Screen screen;
    private int pointSize;
    @Override
    public void update() {
        repaint();
    }
    /**
     * Set's GraphicsLogic constructor by given screen and newPointsize objects
     * @param newScreen Given screen object (game logic)
     * @param newPointSize Set's element size for screen (Snake and tokens)
     */
    public GraphicsLogic(Screen newScreen, int newPointSize) {
        this.screen = newScreen;
        this.pointSize = newPointSize;
        super.setBackground(Color.BLACK);
    }
    /**
     * This method draws snake object element parts by given graphics object 
     * The graphicsLogics contains screen aand snake object
     * @param graphics 
     */    
    private void drawSnake(Graphics graphics) {
        graphics.setColor(Color.GREEN);
        Snake snake = screen.getSnake();
        for (Point point : snake.getBodyparts()) {
            graphics.fill3DRect(
                    point.getX() * this.pointSize,
                    point.getY() * this.pointSize,
                    this.pointSize,
                    this.pointSize,
                    true);
        }
    }
    /**
     * This method draws token object to the screen
     * @param graphics 
     */    
    private void drawToken(Graphics graphics) {
        Token token = screen.getToken();
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(
                token.getX() * this.pointSize,
                token.getY() * this.pointSize,
                this.pointSize,
                this.pointSize);
    }
    /**
     * This is the actual method that uses draw methods to draw the elements on the screen after update cycle.
     * @param graphics 
     */    
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawSnake(graphics);
        drawToken(graphics);
        
        
    }
    
    
    
}
