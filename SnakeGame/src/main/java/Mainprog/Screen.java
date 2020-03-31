/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *
 * @author joelhunn
 */
public class Screen extends Pane {
    private int w;
    private int h;
    
    ArrayList<Point> points =new ArrayList<Point>();
    Snake snake;
    public Screen(int width, int height){
        w= width;
        h=height;
       
        setMinSize(w * Main_ui.blocksize, h * Main_ui.blocksize);
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }
    public int getW(){
        return this.w;
    }
    public int getH(){
        return this.h;
    }
    public void addSnake(Snake dasnake){
        snake=dasnake;
        for(Point p:dasnake.snakepoints){
            addPoint(p);
        }
    }
    private void addPoint(Point poi){
        getChildren().add(poi);
        points.add(poi);
    }

}

