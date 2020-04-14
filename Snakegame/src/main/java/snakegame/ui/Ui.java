/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakegame.ui;


import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        JLabel scoreLabel = new JLabel("score : "); 
        scoreLabel.setBounds(30, 550, 46, 14);
        frame.add(scoreLabel); 
        scoreLabel.setText(String.valueOf(screen.getScores()));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }
    
}
