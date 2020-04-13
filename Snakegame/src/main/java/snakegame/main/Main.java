/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.main;

import javax.swing.SwingUtilities;
import snakegame.domain.Screen;
import snakegame.ui.Ui;
import snakegame.domain.Keylistener;
import snakegame.domain.Update;

/**
 *
 * @author joelhunn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Screen screen = new Screen(20, 20);
        Ui userInterface = new Ui(screen, 20);
        SwingUtilities.invokeLater(userInterface);
        while (userInterface.getUpdate()==null){
            try{
                Thread.sleep(100);
                
            } catch (InterruptedException ex) {
               // System.out.println("Graphics not created.");
            }
        }
        screen.setUpdate(userInterface.getUpdate());
        screen.start();
    }
    
}
