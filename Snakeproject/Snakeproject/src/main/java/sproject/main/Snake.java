/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sproject.main;

import sproject.main.Point;
import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author joelhunn
 */
public class Snake {
    ArrayList<Point> snakepoints = new ArrayList<Point>();
    Point mouth;
    public Snake(int width, int height){
     
        int px = width /2;
        int py = height /2;
        
        mouth = new Point(px,py);
        mouth.setFill(Color.GOLD.desaturate());
        snakepoints.add(mouth);
        snakepoints.add(new Point(width / 2, height / 2));
        snakepoints.add(new Point(width / 2, height / 2));
    }

}
