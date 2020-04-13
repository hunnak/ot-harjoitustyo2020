/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author joelhunn
 */
public class Token extends Rectangle {
    int placeX;
    int placeY;
    
    public Token(int x, int y){
        super(Main_ui.blocksize, Main_ui.blocksize);
        
        placeX=x;
        placeY=y;
        setTranslateX(placeX * Main_ui.blocksize);
        setTranslateY(placeY * Main_ui.blocksize);
        setFill(Color.PURPLE);
        setStroke(Color.LIGHTPINK);
    }
    public void setPlaceX(int placeX) {
        this.placeX = placeX;
    }

    public void setPlaceY(int placeY) {
        this.placeY = placeY;
    }

    public int getPlaceX() {
        return placeX;
    }

    public int getPlaceY() {
        return placeY;
    }    
    
}
