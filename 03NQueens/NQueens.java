import java.util.*;
import java.io.*;


public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2j";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";
    
    //instance variable
    private char[][]board;
    
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
        for(int i=0;i<board.length;i++){
            for(int q=0;q<board[0].length;q++){
                ans += " " + board[i][q];
            }
            ans += "\n";
        }
        return clear + go(0,0) + ans + "\n" + show;
    }


    //Constructor
    public NQueens(int size){
        board = new char[size][size];
        for (int q = 0;q<size;q++){
            for (int p = 0;p<size;p++){
                board[p][q] = '.';
            }
        }
    }

    public boolean solve(){
        for(int i = 0; i < board.length; i++){
            if(solve(i)){
                return true;
            }
        }
        return false;
    }

    public boolean solve(int x){
        board[0][x] = 'Q';
        boolean boo = false;
        for(int i = 0; i < board[0].length; i++){
            boo = boo || solve(1,i);
        }
        if(boo){
            return true;
        }
        board[0][x] = '.';
        return false;
    }

    public boolean solve(int r, int c){
        if(r == board.length){
            return true;
        }
        for(int i = 0; i < board.length; i++){
            for(int q = 0; q < board[0].length; q++){
                if( !(r == i && r == q) && board[i][q] == 'Q' && ((Math.abs(r - i) == Math.abs(c - q)) || r == i || c == q) ){
                    return false;
                }
            }
        }
        board[r][c] = 'Q';
        boolean bleh = false;
        for(int i = 0; i < board[0].length; i++){
            bleh = bleh || solve(r+1,i);
        }
        if(bleh){
            return true;
        }
        board[r][c] = '.';
        return false;
    }
}