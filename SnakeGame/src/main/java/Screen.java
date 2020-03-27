/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

    public Screen(int width, int height){
        w= width;
        h=height;
       
        setMinSize(w * Main_ui.blocksize, h * Main_ui.blocksize);
        setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
        setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(1))));
    }

}

