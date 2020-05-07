/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

public class Point {
    
    int x;
    int y;
    public Point(int xx, int yy) {
        x = xx;
        y = yy;
    }

    public int getX() {
        return x;
    }
        
    public int getY() {
        return y;
    }
    /**
    * Method checks as boolean method does given point object touch this point object
    * @param dapoint given point object coordinates will be check is those the same as this point object
    * @return returns true if points have same coordinates, touch each other
    */      
    public boolean touch(Point dapoint) {
        int daX = dapoint.getX();
        int daY = dapoint.getY();
        if (daX == this.x && daY == this.y) {
            return true;
        } else {
            return false;
        }
        
    }
    
    /**
    * Method returns point creatures x and y parameter boolean parameter grow to be true
    * 
    * returns int x coordinate
    * returns int y coordinate
    * @return return parameters in string format (x,y)
    */   
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

}