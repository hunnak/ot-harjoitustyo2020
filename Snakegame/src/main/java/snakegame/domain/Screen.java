/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 *
 * @author joelhunn
 */
public class Screen extends Timer implements ActionListener {
    private int w;
    private int h;
    
    private Snake snake;
    private Token tokenPlace;
    private boolean gameContinue;
    private Update update;
    private int scores;
    private JTextArea text;
    
    public Screen(int width, int height) {
        super(1000, null);
        this.w = width;
        this.h = height;
        this.gameContinue = true;
        this.tokenPlace = addNewToken();
        this.snake = new Snake(width / 2, height / 2, Direction.Left);
        addActionListener(this);
        setInitialDelay(2000);
    }
    public int getW() {        
        return this.w;
    }
    public int getH() {
        return this.h;
    }
    public boolean gameContinue() {
        return gameContinue;
    }
    public Snake getSnake() {
        return snake;
    }
    public void setSnake(Snake setSnake) {
        this.snake = setSnake;
    }
    public Token getToken() {
        return this.tokenPlace;
    }
    public void setTokenToItsPlace(Token token) {
        this.tokenPlace = token;
    }
    public void setUpdate(Update update) {
        this.update = update;
    }
    public int getScores() {
        return scores;
    }
    private void move() {
        this.snake.move();
    }
    private Token addNewToken() {
        int randomX = (int) (Math.random() * w);
        int randomY = (int) (Math.random() * h);
        
        return new Token(randomX, randomY);
    }
    private void touchToken() {
        if (!snake.touchPoint(tokenPlace)) {
            return;
        }
        scores += 100;
        this.tokenPlace = addNewToken();
        snake.grow();
    }
    private void gotHurt() {
        List<Point> points = snake.getBodyparts();
        Point head = snake.getBodyparts().get(0);
        for (int h = 1; h < snake.getBodyparts().size(); h++) {
            if (head.touch(points.get(h))) {
                gameContinue = false;
                
            }          
        }
    }
    private void updateInterface() {
        this.update.update();
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameContinue) {
            this.stop();
            
            gameOver();
            return;
        }
        move();
        
        touchToken();
        gotHurt();
        updateInterface();
        setDelay(500);
    }
    public void setText(JTextArea text) {
        this.text = text;
    }
    public void gameOver() {
        //this.text.setText("GAME OVER! \n \n You got some sweet " + " scores" + "ps. turn the application on again");
        int returnValue = JOptionPane.showConfirmDialog(text,
				"You got some sweet" + this.scores + "scores! Do you want to start a new game?", "GAME OVER!", JOptionPane
				.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		
		switch (returnValue) {
			case JOptionPane.OK_OPTION:
				// new gme set needs to code 
				break;
				
			case JOptionPane.CANCEL_OPTION:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(text, 
						"Something went wrong :( /n Please relunch app");
				break;
		}
    }

}