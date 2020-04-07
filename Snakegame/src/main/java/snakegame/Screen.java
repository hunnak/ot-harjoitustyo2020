package snakegame;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import snakegame.Main_ui;
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
    static int w;
    static int h;
    
    ArrayList<Point> pointlist = new ArrayList<Point>();
    Snake snake;
    Token tokenPlace;
    int scores;
    public Screen(int width, int height) {
        
        w = width;
        h = height;
        setMinSize(w * Main_ui.blocksize, h * Main_ui.blocksize);
        setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
        setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
        addToken();
    }
    public int getW() {        
        return this.w;
    }
    public int getH() {
        return this.h;
    }
    public void addSnake(Snake dasnake) {
        snake = dasnake;
        for (Point p : snake.snakepoints) {
            addPoint(p);
        }
    }
    private void addPoint(Point poi) {
        getChildren().add(poi);
        this.pointlist.add(poi);
    }
    public void update() {
        for (Point p : pointlist) {
            p.update();
            
        }
        if (isTokenTaken(tokenPlace)) {
            scores += 100;
            addToken();
            updateSnakePoints();
        }
    }
    public void updateSnakePoints() {
        Point p = new Point(snake.lastPoint.oldx, snake.lastPoint.oldy, snake.lastPoint, this);
        snake.lastPoint = p;
        addPoint(p);
    }
    public void addToken() {
        int randomX = (int) (Math.random() * w);
        int randomY = (int) (Math.random() * h);
    
        Token token = new Token(randomX, randomY);
        getChildren().add(token);
        getChildren().remove(tokenPlace);
        this.tokenPlace=token;
    }
    public boolean isTokenTaken(Token tok) {
        if(tok == null) {
            return false;
        }
        return tok.getPlaceX() == snake.mouth.getplaceX() && tok.placeY == snake.mouth.getplaceY();
    }
    public boolean gotHurt() {
        for (Point h : pointlist) {
            if(h != snake.mouth) {
                if(h.getplaceX() == snake.mouth.getplaceX() && h.getplaceY() == snake.mouth.getplaceY()) {
                    return true;
                }          
            }
        } 
        return false;
    }
    

}

