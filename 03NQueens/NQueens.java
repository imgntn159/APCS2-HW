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
        board = new int[size][size];
        for (int q = 0;q<size;q++){
            for (int p = 0;p<size;p++){
                board[p][q] = '.';
            }
        }
    }

    public boolean solve(){
        for (int q = 0;q<board.length;q++){
            if (solve(q)){
                return true;
            }
        }
        return false;
    }

    public boolean solve(int x){
        board[0][x] = 'Q';
        for(int i = 0; i < board[0].length; i++){
            if(solve(x,i)){
                return true;
            }
        }
        board[0][x] = '.';
        return false;
    }

    public boolean solve(int x,int y){
        //System.out.println(this);
        //wait(1);
        if (y == board.length){
            System.out.println(this);
            return true;
        }
        if (x < 0 || x > board.length - 1 ||
            y < 0 || y > board.length - 1 ||
            board[x][y] != 'Q'){
            return false;
        }
        for(int i = 0; i < board.length; i++){
            for(int q = 0; q < board[0].length; q++){
                if(/*something?*/){
                    return false;
                }
            }
        }
        board[x][y] = 'Q';
        if (solve(x,y+1)){
            return true;
        }
        board[x][y] = 0;
        return false;
    }
}