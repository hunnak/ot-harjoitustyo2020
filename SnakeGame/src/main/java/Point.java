/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joelhunn
 */
public class Point {
    
    private int x;
    private int y;
    
    public Point(){
        x=0;
        y=0;
    }
            
    public Point(int x, int y){
        this.x=x;
        this.y=y;
        
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
