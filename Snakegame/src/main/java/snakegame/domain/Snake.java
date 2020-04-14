/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joelhunn
 */
public class Snake {
    
    private ArrayList<Point> snakePoints;
    private Direction direc;
    public boolean grow;
    private static final int MINSIZE = 5;

    public Snake(int newX, int newY, Direction newDirection) {
        this.snakePoints = new ArrayList<Point>();
        this.snakePoints.add(new Point(newX, newY));
        this.direc = newDirection;
        this.grow = false;
    }



    public Direction getDirection() {
        return this.direc;
    }
    public void setDirection(Direction setNewDirection) {
        this.direc = setNewDirection;
    }    
    public int getSnakeLenght() {
        return snakePoints.size();
    }
    public List<Point> getBodyparts() {
        return snakePoints;
    }
    public void move() {
        Point mouth = snakePoints.get(0);
        int newX = mouth.getX();
        int newY = mouth.getY();
        if (this.direc.equals(Direction.Up)) {
            newY = newY - 1;
        } else if (this.direc.equals(Direction.Right)) {
            newX = newX + 1;
        } else if (this.direc.equals(Direction.Down)) {
            newY = newY + 1;
        } else if (this.direc.equals(Direction.Left)) {
            newX = newX - 1;
        }
        this.snakePoints.add(0, new Point(newX, newY));
        if (!this.grow && this.snakePoints.size() > MINSIZE) {
            snakePoints.remove(snakePoints.size() - 1);
        } else {
            this.grow = false;
        }
    }    
   
    public void grow() {
        this.grow = true;
    
    }    
    public boolean touchPoint(Point topoint) {
        for (Point p : this.snakePoints) {
            if (p != topoint && p.touch(topoint)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean touchItself() {
        return touchPoint(this.snakePoints.get(0));
    
    }
}
