import java.util.*;
import java.io.*;

public class Maze{
	private static final String clear =  "\033[2J";
	private static final String hide =  "\033[?25l";
	private static final String show =  "\033[?25h";
	private static final String invert =  "\033[37";

	private Frontier front;
	private boolean behave;
	private char[][]maze;
	private int maxx,maxy;
	private int startx,starty,endx,endy;

	private String go(int x,int y){
		return ("\033[" + x + ";" + y + "H");
	}
	public void wait(int millis){
		try{
	    Thread.sleep(millis);
		}
		catch(InterruptedException e){
		}
  }

	/** Same constructor as before...*/
	public Maze(String filename){
		startx = -1;
		starty = -1;
		String ans = "";
		try{
			Scanner in = new Scanner(new File(filename));
			//keep reading next line
			while(in.hasNext()){
				String line= in.nextLine();
				if(maxy==0){
				//calculate width of the maze
					maxx=line.length();
				}
				//every new line add 1 to the height of the maze
				maxy++;
				ans+=line;
			}
		}
		catch(Exception e){
			System.out.println("File: "+filename+" could not be opened.");
			e.printStackTrace();
			System.exit(0);
		}
		maze = new char[maxx][maxy];
		for(int i=0;i<ans.length();i++){
			char c = ans.charAt(i);
			maze[i%maxx][i/maxx]= c;
			if(c=='S'){
				startx = i%maxx;
				starty = i/maxx;
			}
		}
		for(int i=0;i<ans.length();i++){
			char c = ans.charAt(i);
			maze[i%maxx][i/maxx]= c;
			if(c=='E'){
				endx = i%maxx;
				endy = i/maxx;
			}
		}
	}

	public String toString(){
		String ans = ""+maxx+","+maxy+"\n";
		for(int i=0;i<maxx*maxy;i++){
			if(i%maxx ==0 && i!=0){
				ans+="\n";
			}
			ans += maze[i%maxx][i/maxx];
		}
		return ans;
	} //do not do the funky character codes

	public String toString(boolean animate){
		if (animate){
			String ans = ""+maxx+","+maxy+"\n";
			for(int i=0;i<maxx*maxy;i++){
				if(i%maxx ==0 && i!=0){
					ans+="\n";
				}
				ans += maze[i%maxx][i/maxx];
			}
			return hide+invert+go(0,0)+ans+"\n"+show;
		}else{
			return toString();
		}
	} //do the funky character codes when animate is true*/

	public boolean solveBFS(boolean animate){
		return solve1(animate,0);
	}
	public boolean solveDFS(boolean animate){
		return solve1(animate,1);	
	}
	public boolean solveBest(boolean animate){
		return solve1(animate,2);	
	}
	public boolean solveAStar(boolean animate){
		return solve1(animate,3);	
	}

	public boolean solveBFS(){
		return solveBFS(false);
	}
	public boolean solveDFS(){
		return solveDFS(false);
	}
	public boolean solveBest(){
		return solveBest(false);
	}
	public boolean solveAStar(){
		return solveBest(false);
	}

	public Point[] getNeighbors(Point p){
		Point[] result = new Point[4];
		int pos = 0;
		if (!(maze[p.getX()+1][p.getY()] == '.' || maze[p.getX()+1][p.getY()] == '#')){
			result[pos] = new Point(p.getX()+1,p.getY(),p.getC()+1,p);
			pos++;
		}
		if (!(maze[p.getX()-1][p.getY()] == '.' || maze[p.getX()-1][p.getY()] == '#')){
			result[pos] = new Point(p.getX()-1,p.getY(),p.getC()+1,p);
			pos++;
		}
		if (!(maze[p.getX()][p.getY()+1] == '.' || maze[p.getX()][p.getY()+1] == '#')){
			result[pos] = new Point(p.getX(),p.getY()+1,p.getC()+1,p);
			pos++;
		}
		if (!(maze[p.getX()][p.getY()-1] == '.' || maze[p.getX()][p.getY()-1] == '#')){
			result[pos] = new Point(p.getX(),p.getY()-1,p.getC()+1,p);
			pos++;
		}
		return result;

	}

	private boolean solve1(boolean animate, int mode){
		Frontier rest = new Frontier(mode); //0 BFS, 1 DFS, 2 Best, 3 AStar
		Point start = new Point(startx,starty,0);

		rest.add(start);//put the start into the Frontier 

		boolean solved = false;
		while(!solved && rest.hasNext()){
			if(animate && !solved){
				wait(50);
				System.out.println(toString(true));
			}
			//get the top
			Point next = rest.remove();
			//check if solved
			if(maze[next.getX()][next.getY()]=='E'){
			//solved!
				solved = true;
			    addCoordinatesToSolutionArray(next);
			    System.out.println(toString());
			}else{
			//not solved, so add neighbors to Frontier and mark the floor with x.
				maze[next.getX()][next.getY()]='.';
				for(Point p : getNeighbors(next)){
					if(p!=null){
						if(mode == 2){
							rest.add(p,getDistance(p));
						}else if(mode == 3){
							rest.add(p,getDistance(p)+p.getC());
						}else{
							rest.add(p);
						}
					}
				}
			}
		}
		return solved;
	}
	private int getDistance(Point p){
		return Math.abs(p.getX()-endx) + Math.abs(p.getY()-endy);
	}
	private void addCoordinatesToSolutionArray(Point p){
	    Point temp = p;
	    ArrayList<Point> list = new ArrayList<Point>();
	    while(temp.getPrev() != null){
	    	  list.add(temp);
	        maze[temp.getX()][temp.getY()] = 'o';
	        temp = temp.getPrev();
	    }
	    System.out.println();
	    for(Point thing : list){
	    	System.out.print(thing + "=>");
	    }
	}

	public static void main(String[]args){
    Maze thing;
    if (args.length < 1){
	    thing = new Maze("data1.dat");
    }else{
        thing = new Maze(args[0]);
    }
		System.out.println(thing.solveDFS(true));
	}
}
