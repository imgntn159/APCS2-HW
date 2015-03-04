public class silver{
    private char[][] land;
    private int length,sX,sY,eX,eY;
    public silver(char[][] l,int len,int sX,int sY,int eX,int eY){
        land = l;
        length = len;
        this.sX = sX-1;
        this.sY = sY-1;
        this.eX = eX-1;
        this.eY = eY-1;
    }
    public int find(){
        return findH(0,sX,sY);
    }
    public int findH(int timer,int x,int y){
        if (timer >= length 
            || x > land.length-1 
            || y > land[0].length-1 
            || x < 0 || y < 0
            || land[x][y] == '*'){
            return 0;
        }
        if (timer == length && x == eX && y == eY){
            return 1;
        }
        return
        findH(timer + 1,x+1,y) +
        findH(timer + 1,x-1,y) +
        findH(timer + 1,x,y+1) +
        findH(timer + 1,x,y-1);
    }


    /*Driver*/
    public static void main(String[]args){
        char[][] thingy = new char[][]{
            { '.', '.', '.', '*', '.' },
            { '.', '.', '.', '*', '.' },
            { '.', '.', '.', '.', '.' },
            { '.', '.', '.', '.', '.' }
        };
        //row 1:  ...*.
        //row 2:  ...*.
        //row 3:  .....
        //row 4:  .....
        silver a = new silver(thingy,6,1,3,1,5);
        System.out.println(a.find());
    }
 
}