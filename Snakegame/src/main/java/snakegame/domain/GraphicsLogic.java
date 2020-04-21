/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import snakegame.domain.Screen;

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
    public GraphicsLogic(Screen newScreen, int newPointSize) {
        this.screen = newScreen;
        this.pointSize = newPointSize;
        super.setBackground(Color.BLACK);
    }
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
    private void drawToken(Graphics graphics) {
        Token token = screen.getToken();
        graphics.setColor(Color.ORANGE);
        graphics.fillOval(
                token.getX() * this.pointSize,
                token.getY() * this.pointSize,
                this.pointSize,
                this.pointSize);
    }
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        drawSnake(graphics);
        drawToken(graphics);
        
    }
    
    
    
}
