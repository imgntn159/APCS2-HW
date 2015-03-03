public class silver{
    private int[][] land = new int[3][3];
    private int depth = 0;
    public silver(int[][] l, int d){
        land = l;
        depth = d;
    }


    /*Driver*/
    public static void main(String[]args){
        int[][] thingy = new int[][]{
            { 28, 25, 20, 32, 34, 36 },
            { 27, 25, 20, 20, 30, 34 },
            { 24, 20, 20, 20, 20, 30 },
            { 20, 20, 14, 14, 20, 20 }
        };
        //row 1:  28 25 20 32 34 36
        //row 2:  27 25 20 20 30 34
        //row 3:  24 20 20 20 20 30
        //row 4:  20 20 14 14 20 20
    }
 
}