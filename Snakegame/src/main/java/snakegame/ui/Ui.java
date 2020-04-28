/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.ui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import snakegame.domain.GraphicsLogic;
import snakegame.domain.Keylistener;
import snakegame.domain.Screen;
import snakegame.domain.Update;
/**
 *
 * @author joelhunn
 */
public class Ui implements Runnable {
    
    private JFrame frame;
    private GraphicsLogic graphicsLogic;
    private Screen screen;
    private int pointSize;
    
    public Ui(Screen newScreen, int newPointSize) {
        this.screen = newScreen;
        this.pointSize = newPointSize;
    }
    private void createComponents(Container container) {
        this.graphicsLogic = new GraphicsLogic(this.screen, this.pointSize);
        container.add(graphicsLogic);
        Keylistener keylistener = new Keylistener(screen.getSnake());
        frame.addKeyListener(keylistener);
        
        JButton startGame = new JButton("Bring da snake!");
        JTextArea textarea = new JTextArea();
        JButton instruction = new JButton("Let me tell about da snake");
        JButton scoretable = new JButton("Score table");
        
        container.add(textarea);
        
        container.add(startGame, BorderLayout.SOUTH);
        
        
        container.add(selection(instruction, scoretable), BorderLayout.CENTER);
        
        
    }
    public Update getUpdate() {
        return graphicsLogic; 
    }
    public JFrame getFrame() {
        return frame;
    }
    @Override
    public void run() {
        frame = new JFrame("Do you dare to play Snake Game");
        frame.setPreferredSize(new Dimension(600, 600));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
    public JPanel selection(JButton instruction, JButton scoretable) {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        panel.add(instruction);
        panel.add(scoretable);
     
        
        return panel;
    }
        
        
        
    
    
}
