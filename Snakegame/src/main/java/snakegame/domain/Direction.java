/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

/**
 *
 * @author joelhunn
 */
public enum Direction {
        Left, Right, Down, Up;
        
        
        public String printDirection() {
        String message = "You are moving " + this + " direction";
        System.out.println( message );
        
        return message;
    }
        
}
    

