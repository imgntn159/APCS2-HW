public class Point{
    private int x,y;
    private Point prev;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
        prev = null;
    }
    public Point(int x, int y, Point prev){
        this.x = x;
        this.y = y;
        this.prev = prev;
    }
    public int getX(){
       return x;
    }
    public int getY(){
        return y;
    }
    public Point getPrev(){
        return prev;
    }
    public String toString(){
        return "(" + x + "," + y + ")";
    }
}