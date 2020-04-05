package snakegame;



import snakegame.Main_ui;
import javafx.scene.shape.Rectangle;

import snakegame.Main_ui;

public class Point extends Rectangle{
    static final int UP=0;
    static final int RIGHT=1;
    static final int DOWN=2;
    static final int LEFT=3;
    
    int x;
    int y;
    int oldx;
    int oldy;
    
    Point previous;
    
    int direction=UP;
    
    int maxX;
    int maxY;
    
    public Point(int x, int y, Point p, Screen screen){
        super(Main_ui.blocksize, Main_ui.blocksize);
        this.x=x;
        this.y=y;
        
        setTranslateX(this.x*Main_ui.blocksize);
        setTranslateY(this.y*Main_ui.blocksize);
        previous=p;
        maxX=screen.getW();
        maxY=screen.getH();
    }
    public void moveUp(){
        this.y--;
        if(y<0){
            y=maxY-1;
        }
    }
    public void moveRight(){
        this.x++;
        if(x<=maxX){
            x=0;
        }
    }
    public void moveDown(){
        this.y++;
        if(y>=maxY){
            y=0;
        }
    }
    public void moveLeft(){
        this.x--;
        if(x<0){
            x=maxX-1;
        }
    }
    public void update(){
        oldx=x;
        oldy=y;
        if(previous == null){
            switch(direction){
            case UP:
                moveUp();
                break;
            case RIGHT:
                moveRight();
                break;
            case DOWN:
                moveDown();
                break;        
            case LEFT:
                moveLeft();
                break;        
            }
        }else{
            x=previous.oldx;
            y=previous.oldy;
        }
        updatePlace();
    }
    public void updatePlace(){
        
        setTranslateX(x* Main_ui.blocksize);
        setTranslateY(y* Main_ui.blocksize);
    }
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    
}
