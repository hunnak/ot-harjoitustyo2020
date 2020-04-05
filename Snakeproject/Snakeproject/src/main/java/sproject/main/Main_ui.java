/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject.main;


import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import sproject.main.Point;


/**
 *
 * @author joelhunn
 */
public class Main_ui extends Application {
    static boolean gameOver = false;
    static int width = 50;
    static int height = 50;
    static Dir direction = Dir.left;
    static Snake snake = new Snake(width,height);
    
    public enum Dir {
	left, right, up, down
    }
    
    public void start(Stage primaryStage) {
    	VBox root = new VBox();
	Canvas c = new Canvas(width , height );
	GraphicsContext gc = c.getGraphicsContext2D();
        root.getChildren().add(c);
        
        
			

	Scene scene = new Scene(root, width , height);
        
        scene.addEventFilter(KeyEvent.KEY_PRESSED, key -> {
				if (key.getCode() == KeyCode.UP) {
					direction = Dir.up;
				}
				if (key.getCode() == KeyCode.LEFT) {
					direction = Dir.left;
				}
				if (key.getCode() == KeyCode.DOWN) {
					direction = Dir.down;
				}
				if (key.getCode() == KeyCode.RIGHT) {
					direction = Dir.right;
				}

			});
        
        primaryStage.setScene(scene);
	primaryStage.setTitle("SNAKE GAME");
        primaryStage.show();
        
        
    }
    public static void Graphics(GraphicsContext gc) {
		if (gameOver) {
			gc.setFill(Color.RED);
			gc.setFont(new Font("", 50));
			gc.fillText("GAME OVER", 100, 250);
			return;
		}
                for (int i = snake.getSize() - 1; i >= 1; i--) {                
		    
                    snake.Get(i).setX(snake.Get(i-1).getX());
                    snake.Get(i).setY(snake.Get(i-1).getY());
		}

		switch (direction) {
		case up:
			snake.Get(0).setY(snake.Get(0).getY()-1);
			if (snake.Get(0).getY() < 0) {
				gameOver = true;
			}
			break;
		case down:
			snake.Get(0).setY(snake.Get(0).getY()+1);
			if (snake.Get(0).getY() > height) {
				gameOver = true;
			}
			break;
		case left:
			snake.Get(0).setX(snake.Get(0).getX()-1);
			if (snake.Get(0).getX() < 0) {
				gameOver = true;
			}
			break;
		case right:
			snake.Get(0).setX(snake.Get(0).getX()+1);
			if (snake.Get(0).getX() > width) {
				gameOver = true;
			}
			break;

		}
                // If snake hits itself
		for (int i = 1; i < snake.getSize(); i++) {
			if (snake.Get(i).getX() == snake.Get(i).getX() && snake.Get(0).getY() == snake.Get(i).getY()) {
				gameOver = true;
			}
		}
                
    }            

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(Main_ui.class);
        // TODO code application logic here
    }
    
}
