/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

/**
 *
 * @author joelhunn
 * 
 * This method is called whenever the observed object is changed.
 * An application calls an Observable object's notify
 * Observers method to have all the object's observers notified of the change.
 */

public interface Update {
    void update();
    
}
