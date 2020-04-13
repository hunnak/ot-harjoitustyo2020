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
    private boolean grow;
    public Snake(int newX, int newY, Direction newDirection){
        this.snakePoints= new ArrayList<Point>();
        this.snakePoints.add( new Point(newX, newY));
        this.direc=newDirection;
        this.grow=false;
    }
    //Luokka Suunta löytyy valmiina pakkauksesta Matopeli.domain.

    //Mato luodaan yhden palan pituisena, mutta madon "aikuispituus" on kolme. Madon tulee kasvaa yhdellä aina kun se liikkuu. Kun madon pituus on kolme, se kasvaa isommaksi vain syödessään.



    public Direction getDirection(){
        return this.direc;
    }
    public void setDirection(Direction setNewDirection){
        this.direc = setNewDirection;
    }    
    public int getSnakeLenght(){
        return snakePoints.size();
    }
    public List<Point> getBodyparts(){
        return snakePoints;
    }
    public void move(){
        Point mouth = snakePoints.get(0);
        int newX = mouth.getX();
        int newY = mouth.getY();
        if(this.direc.equals(Direction.Up)){
            newY = newY-1;
        } else if (this.direc.equals(Direction.Right)) {
            newX = newX + 1;
        } else if (this.direc.equals(Direction.Down)) {
            newY = newY + 1;
        } else if (this.direc.equals(Direction.Left)) {
            newX = newX - 1;
        }
        this.snakePoints.add(0, new Point(newX, newY));
    }    
   
    public void grow(){
        this.grow=true;
    //kasvattaa madon kokoa yhdellä. Madon kasvaminen tapahtuu seuraavan liiku-metodikutsun yhteydessä. Sitä seuraaviin liiku-kutsuihin kasvaminen ei enää vaikuta. Jos madon pituus on 1 tai 2 kun metodia kutsutaan, ei kutsulla saa olla mitään vaikutusta matoon.    
    }    
    public boolean touchPoint(Point topoint){
        for (Point p : this.snakePoints) {
            if(p != topoint && p.touch(topoint)){
                return true;
            }
        }
        return false;
    }
    //tarkistaa osuuko mato parametrina annettuun palaan. Jos mato osuu palaan, eli joku madon pala osuu metodille parametrina annettuun palaan, tulee metodin palauttaa arvo true. Muuten metodi palauttaa arvon false.
    public boolean touchItself(){
        
    return touchPoint(this.snakePoints.get(0));
    //tarkistaa osuuko mato itseensä. Jos mato osuu itseensä, eli joku sen pala osuu johonkin toiseen sen palaan, metodi palauttaa arvon true. Muuten metodi palauttaa arvon false.public void 
    }
}
