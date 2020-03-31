import javafx.scene.shape.Rectangle;

public class Point extends Rectangle{
    
    private int x;
    private int y;
    private int oldx;
    private int oldy;
    
    Point previous;
    
    public Point(int x, int y, Point p){
        super(Main_ui.blocksize, Main_ui.blocksize);
        this.x=x;
        this.y=y;
        
        setTranslateX(this.x*Main_ui.blocksize);
        setTranslateY(this.y*Main_ui.blocksize);
    }
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    //public int getX(){
    //    return this.x;
    //}
    //public int getY(){
    //    return this.y;
    //}
}
