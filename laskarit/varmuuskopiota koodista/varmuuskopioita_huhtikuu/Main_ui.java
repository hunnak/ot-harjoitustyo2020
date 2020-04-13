package snakegame.ui;


import javafx.animation.AnimationTimer;
import snakegame.ui.Snake;
import snakegame.ui.Screen;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import static javafx.scene.text.Font.font;
import javafx.stage.Stage;

public class Main_ui extends Application {
    
    static int blocksize=10;
    static int width=60;
    static int height=30;
    int snakelenght=5;
    long then = System.nanoTime();
    boolean changed=false;
    int newUpdate;
    boolean isThereNext=false;
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
        Label score = new Label("Score: " + screen.scores);
        score.setFont(Font.font("Verdana",40));
        
        AnimationTimer timer = new AnimationTimer(){

            public void handle(long now){
                if(now-then> 1000000000/5)
                screen.update();
                then=now;
                changed = false;
                if(isThereNext){
                    setDirection(screen.snake,newUpdate);
                    isThereNext=false;
                }
                if(screen.gotHurt()){
                    stop();
                    Alert achtung = new Alert(AlertType.INFORMATION);
                    achtung.setHeaderText("Auts, game over");
                    achtung.setContentText("Score gathered"+ screen.scores);
                    Platform.runLater(achtung::showAndWait);
                    
                    achtung.setOnHidden(e -> {
                        root.getChildren().clear();
                        Screen endscreen = new Screen(width, height);
                        screen.addSnake(new Snake(snakelenght, screen));
                        score.setText("Score: 0");  
                        root.getChildren().add(screen);
                        start();
                    });
                            
                }
            }
        };
        
        timer.start();
        root.getChildren().addAll(screen, score);
        
        Scene scene=new Scene(root);
        
        scene.setOnKeyPressed(value ->{
            if(value.getCode().equals(KeyCode.UP) && screen.snake.getDirection() != Point.DOWN){
                setDirection(screen.snake, Point.UP);
            }
            if(value.getCode().equals(KeyCode.DOWN) && screen.snake.getDirection() != Point.UP){
                setDirection(screen.snake, Point.DOWN);
            }
            if(value.getCode().equals(KeyCode.RIGHT) && screen.snake.getDirection() != Point.LEFT){
                setDirection(screen.snake, Point.RIGHT);
            }
            if(value.getCode().equals(KeyCode.LEFT) && screen.snake.getDirection() != Point.RIGHT){
                setDirection(screen.snake, Point.LEFT);
            }
        });     
        
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Snake Game");
        
        primaryStage.show();
        
        
    }
    public void setDirection(Snake s, int direc){
        if(!changed){
            s.setDirection(direc);
            changed= true;
        }else{
            isThereNext=true;
            newUpdate= direc;
        }
    }
    
    
}
