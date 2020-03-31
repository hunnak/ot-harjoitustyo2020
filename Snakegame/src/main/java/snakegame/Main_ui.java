package snakegame;

import snakegame.Snake;
import snakegame.Screen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_ui extends Application {
    
    static int blocksize=10;
    
    int width=30;
    int height=15;
    
    int snakelenght=5;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(Main_ui.class);
        // TODO code application logic here
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(10);
        
        root.setPadding(new Insets(10));
        
        Screen screen = new Screen(width, height);
        screen.addSnake(new Snake(this.snakelenght, screen));
        root.getChildren().add(screen);
        
        Scene scene=new Scene(root);
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        
        primaryStage.show();
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
