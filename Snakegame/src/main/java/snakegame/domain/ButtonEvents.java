/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/**
 *
 * @author joelhunn
 * 
 * THIS CLASS IS NOT USED, maybe in the future.
 */

public class ButtonEvents implements ActionListener {

    private Screen screen;
    private JFrame frame;
    private JTextArea textfield;
    private JButton start;
    private JButton intro;
    private JButton scoretable;

    
    public ButtonEvents(Screen scree, JFrame frame, JTextArea text, JButton start, JButton intro, JButton score) {
        this.screen = scree;
        this.frame = frame;
        this.textfield = text;
        this.start = start;
        this.intro = intro;
        this.scoretable = score;
        
    }

    @Override
    public void actionPerformed(ActionEvent action) {
      //game start inside this method for start button
        //if (action.getSource() == start) {
      //      this.frame.requestFocus();
    //        this.screen.start();
  
       // }
        if (action.getSource() == this.intro) {
            this.textfield.setText("How to play: \n" + readFile("intro.txt"));
        }
        
        if (action.getSource() == this.scoretable) {
            this.textfield.setText("Scoretable: \n" + readFile("scorePoints.txt"));
        }
        

    }
    

 // @param tiedoston nimi
 
    public String readFile(String file) {
        Scanner scanner = null;
        
        try {
            scanner = new Scanner(new File(file));
        } catch (Exception e) {
            System.out.println("Did not find file to read for the button event");
        }
        
        String textlines = "";
        
        while (scanner.hasNextLine()) {
            textlines += scanner.nextLine() + " \n";
        }
        
        scanner.close();
        
        return textlines;
    }
    
}
