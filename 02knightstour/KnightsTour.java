import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private int[][]board;
    
    //terminal specific character to move the cursor
    private String go(int x,int y){
        return ("\033[" + x + ";" + y + "H");
    }
    
    public void wait(int millis){
        try {
            Thread.sleep(millis);
        }
        catch (InterruptedException e) {
        }
    }
    
    public String toString(){
        String ans = "\n";
        for(int i=0;i<5;i++){
            for(int q=0;i<5;q++){
		ans += " ";
                ans += board[i][q];
            }
            ans += "\n";
        }
        return clear + go(0,0) + ans + "\n" + show;
    }
    
    
    //Constructor
    public KnightsTour(int size){
        board = new int[size][size];
	for (int q = 0;q<size;q++){
	    for (int p = 0;p<size;p++){
		board[p][q] = 0;
	    }
	}
    }
    
    
    public void solve(){
        solve(0,0);
    }
    
    public void solve(int startx, int starty){
        solve(startx, starty, 1);
    }
    
    
    
    public boolean solve(int x,int y,int currentMoveNumber){
        //System.out.println(this);
        //wait(20);
        if (currentMoveNumber == (board.length) * (board.length)){
            return true;
        }
        if (x < 0 || x > board.length - 1 ||
            y < 0 || y > board.length - 1 ||
            board[x][y] != 0){
            return false;
	}
	board[x][y] = currentMoveNumber;
	if (solve(x+2,y+1,currentMoveNumber+1) ||
	    solve(x+2,y-1,currentMoveNumber+1) ||
	    solve(x-2,y+1,currentMoveNumber+1) ||
	    solve(x-2,y-2,currentMoveNumber+1) ||
	    solve(x+1,y+2,currentMoveNumber+1) ||
	    solve(x+1,y-2,currentMoveNumber+1) ||
	    solve(x-1,y+2,currentMoveNumber+1) ||
	    solve(x-1,y-2,currentMoveNumber+1)){
	    return true;
	}
	board[x][y] = 0;
	return false;
    }


}