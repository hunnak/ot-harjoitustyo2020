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
    /**
    * Method return screen object int width parameter 
    * @return parameter int width named as w
    */ 
    public int getW() {        
        return this.w;
    }
    /**
    * Method return screen object int height parameter 
    * @return parameter int height named as h
    */ 
    public int getH() {
        return this.h;
    }
        /**
    * Method return screen's boolean gamecontinue parameter 
    * @return boolean value true or false based on given parameter, it is used to check the state of game.
    */ 
    public boolean gameContinue() {
        return gameContinue;
    }
        /**
    * Method returns screen's snake object 
    * @return snake object
    */ 
    public Snake getSnake() {
        return snake;
    }
    /**
    * Method sets screen's snake object with given snake object
    * @param setSnake given snake object
    */ 
    public void setSnake(Snake setSnake) {
        this.snake = setSnake;
    }
    /**
    * Method return screen's Token object  
    * @return Token object
    */ 
    public Token getToken() {
        return this.tokenPlace;
    }
    /**
    * Method sets screen's Token object with given Token object
    * @param setSnake given Token object
    */    
    public void setTokenToItsPlace(Token token) {
        this.tokenPlace = token;
    }
    /**
    * 
    * This method is called whenever the screen object state is changed.
    * method to have all the object's observers notified of the change.
    * This method gives chance to change set update inteface state.
    */
    public void setUpdate(Update update) {
        this.update = update;
    }
    /**
    * Method return screen's score parameter 
    * @return scores integer
    */ 
    public int getScores() {
        return scores;
    }
    /**
    * Method sets screen's Token object with given Token object
    * @param setSnake given Token object
    */ 
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
    private void outOfScreen() {
        List<Point> bodyparts = this.snake.getBodyparts();
        Point snakeMouth = bodyparts.get(this.snake.getSnakeLenght() - 1);
        
        if (snakeMouth.getX() < 0 || snakeMouth.getX() > this.w) {
            this.gameContinue = false;

        } else if (snakeMouth.getY() < 0 || snakeMouth.getY() > this.h) {
            this.gameContinue = false;
            
        }        
    }
    /**
    * 
    * This method is called whenever the screen object state is changed.
    * method to have all the object's observers notified of the change.
    */
    private void updateInterface() {
        this.update.update();
    }
    /**
    * Method uses actionListener
    *first method checks boolesan parameter state if method would continue. 
    * If parameter gameContinue is false action method stops timer thread and calls gameOver method.
    * If game state continue method cals move method for move snake object, 
    * then check does any part of snake touch token, if it does snake grow, otherwise dont.
    * then calls gotHurt method which checks have snake head collide any of its own parts and puts gameContinue boolean false if it does.
    * Then calls outOfScreen to check have snakemouth collide walls as same procedure than previous method.
    * Then calls updateInterface method to notify all screen object changes
    * then sets to timer delay with 500 unit.
    * @param e given action object
    */ 
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
        outOfScreen();
        updateInterface();
        setDelay(500);
    }
    //public void setText(JTextArea text) {
    //    this.text = text;
    //}
    
    /**
    * Method ends the game and actionperformed loop, tells in the new screen that game is over
    * gives ok or cancel option
    * ok start game over again
    * cancel shuts the application.
    *@             
    */ 
    public void gameOver() {
        //this.text.setText("GAME OVER! \n \n You got some sweet " + " scores" + "ps. turn the application on again");
        int returnValue = JOptionPane.showConfirmDialog(text,
            "You got some sweet " + this.scores + " scores! Do you want to start a new game?", "GAME OVER!", JOptionPane
            .OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		
        switch (returnValue) {
            case JOptionPane.OK_OPTION:
                freshGame();
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
    /**
     * Fresh start, sets all objects at the class as the game has started over again
     */
    public void freshGame() {
        
        this.snake = new Snake(this.w / 2, this.h / 2, Direction.Left);
        this.tokenPlace = addNewToken();
        this.gameContinue = true;
        this.scores = 0;
            
            
        this.addActionListener(this);
            
        this.start();
        setInitialDelay(2000);
        
    }    

}