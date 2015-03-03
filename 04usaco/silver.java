public class silver{
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
        usaco a = new usaco(thingy, 22);
        a.instruction(1, 1, 4);
        a.instruction(1, 1, 10);
        System.out.println(a.calculate());
    }
}