package snakegame;

import javafx.animation.AnimationTimer;
import snakegame.Snake;
import snakegame.Screen;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main_ui extends Application {
    
    static int blocksize=10;
    
    static int width=60;
    static int height=30;
    
    int snakelenght=5;
    
    long then = System.nanoTime();
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
        
        
        
        AnimationTimer timer = new AnimationTimer(){
            public void handle(long now){
                if(now-then> 1000000000/8)
                screen.update();
                then=now; 
            }
        };
        
        timer.start();
        root.getChildren().add(screen);
        
        Scene scene=new Scene(root);
        
        scene.setOnKeyPressed(value ->{
            if(value.getCode().equals(KeyCode.UP) && screen.snake.getDirection() != Point.DOWN){
                screen.snake.setDirection(Point.UP);
            }
            if(value.getCode().equals(KeyCode.DOWN) && screen.snake.getDirection() != Point.UP){
                screen.snake.setDirection(Point.DOWN);
            }
            if(value.getCode().equals(KeyCode.RIGHT) && screen.snake.getDirection() != Point.LEFT){
                screen.snake.setDirection(Point.RIGHT);
            }
            if(value.getCode().equals(KeyCode.LEFT) && screen.snake.getDirection() != Point.RIGHT){
                screen.snake.setDirection(Point.LEFT);
            }
        });     
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        
        primaryStage.show();
        
        
    }
    
}
