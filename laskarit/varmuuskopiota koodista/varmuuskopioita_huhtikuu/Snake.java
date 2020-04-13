package snakegame.ui;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joelhunn
 */
import java.util.ArrayList;
import javafx.scene.paint.Color;

public class Snake {
    ArrayList<Point> snakepoints;
    
    Point mouth;
    Point lastPoint;
     
    public Snake(int p, Screen s){
        this.snakepoints= new ArrayList<Point>();
        int px = s.getW() /2;
        int py = s.getH() /2;
        
        mouth = new Point(px,py,null,s);
        mouth.setFill(Color.GOLD.desaturate());
        snakepoints.add(mouth);
        lastPoint = mouth;
        
        
        for( int i=1; i<p; i++){
            Point poi = new Point(px+i, py, lastPoint, s);
            snakepoints.add(poi);
            lastPoint=poi;
        }
    } 
    public void setDirection(int direc){
        mouth.direction=direc;
    }
    public int getDirection(){
        return mouth.direction;
    }
     
     
     
}  
