/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author joelhunn
 */
public class Keylistener extends KeyAdapter {
    
    private Snake snake;
    public Keylistener(Snake dasnake) {
        this.snake = dasnake;
    }
    
    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP && this.snake.getDirection() != Direction.Down ) {
            snake.setDirection(Direction.Up);
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT && this.snake.getDirection() != Direction.Left) {
            snake.setDirection(Direction.Right);
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN && this.snake.getDirection() != Direction.Up) {
            snake.setDirection(Direction.Down);
        } else if (event.getKeyCode() == KeyEvent.VK_LEFT && this.snake.getDirection() != Direction.Right) {
            snake.setDirection(Direction.Left);
        }
    }
    public Direction forTestDirection() {
        return this.snake.getDirection();
    }
    
}
