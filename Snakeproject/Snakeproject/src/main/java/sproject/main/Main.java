/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject.main;


import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author joelhunn
 */
public class Main {
    static boolean gameOver = false;
    static int width = 50;
    static int height = 50;
    
    public void start(Stage primaryStage) {
    	VBox root = new VBox();
	Canvas c = new Canvas(width , height );
	GraphicsContext gc = c.getGraphicsContext2D();    

	}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
