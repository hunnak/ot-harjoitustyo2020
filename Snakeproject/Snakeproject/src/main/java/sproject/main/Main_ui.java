/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject.main;


import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
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
    
    public enum Dir {
	left, right, up, down
    }
    
    public void start(Stage primaryStage) {
    	VBox root = new VBox();
	Canvas c = new Canvas(width , height );
	GraphicsContext gc = c.getGraphicsContext2D();
        root.getChildren().add(c);

	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
        // TODO code application logic here
    }
    
}
