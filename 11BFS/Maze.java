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
	private int startx,starty;

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

	/**Solve the maze using a frontier in a BFS manner. 
	* When animate is true, print the board at each step of the algorithm.
	* Replace spaces with x's as you traverse the maze. 
	*/
	public boolean solveBFS(boolean animate){
		return solve1(animate,true);
	}

	/**Solve the maze using a frontier in a DFS manner. 
	* When animate is true, print the board at each step of the algorithm.
	* Replace spaces with x's as you traverse the maze. 
	*/
	public boolean solveDFS(boolean animate){
		return solve1(animate,false);	
	}

	public boolean solveBFS(){
		return solveBFS(false);
	}
	public boolean solveDFS(){
		return solveDFS(false);
	}

	public Point[] getNeighbors(Point p){
		Point[] result = new Point[4];
		int pos = 0;
		if (!(maze[p.getX()+1][p.getY()] == '.' || maze[p.getX()+1][p.getY()] == '#')){
			result[pos] = new Point(p.getX()+1,p.getY(),p);
			pos++;
		}
		if (!(maze[p.getX()-1][p.getY()] == '.' || maze[p.getX()-1][p.getY()] == '#')){
			result[pos] = new Point(p.getX()-1,p.getY(),p);
			pos++;
		}
		if (!(maze[p.getX()][p.getY()+1] == '.' || maze[p.getX()][p.getY()+1] == '#')){
			result[pos] = new Point(p.getX(),p.getY()+1,p);
			pos++;
		}
		if (!(maze[p.getX()][p.getY()-1] == '.' || maze[p.getX()][p.getY()-1] == '#')){
			result[pos] = new Point(p.getX(),p.getY()-1,p);
			pos++;
		}
		return result;

	}

	private boolean solve1(boolean animate, boolean mode){
		Frontier rest = new Frontier(mode); //true then q
		Point start = new Point(startx,starty);

		rest.add(start);//put the start into the Frontier 

		boolean solved = false;
		while(!solved && rest.hasNext()){
			if(animate && !solved){
				wait(50);
				System.out.println(toString(true));
			}
			//get the top
			System.out.println(rest);
			Point next = rest.remove();
			//System.out.println(next);
			//check if solved
			if(maze[next.getX()][next.getY()]=='E'){
			//solved!
				solved = true;
			  addCoordinatesToSolutionArray(next);
			  System.out.println(toString());
			}else{
				//not solved
				//System.out.println(rest);
				maze[next.getX()][next.getY()]='.';
				for(Point p : getNeighbors(next)){
					if(p!=null){
						//System.out.println(p);
						rest.add(p);
						//System.out.println(rest);
						//System.out.println("---------");
					}
				}
			}
		}
		return solved;
	}
	private void addCoordinatesToSolutionArray(Point p){
	    Point temp = p;
	    while(temp.getPrev() != null){
	        //System.out.print(temp);
	        maze[temp.getX()][temp.getY()] = 'o';
	        temp = temp.getPrev();
	    }
	}

	public static void main(String[]args){
	    Maze thing;
	    if (args.length < 1){
		    thing = new Maze("data1.dat");
	    }else{
	        thing = new Maze(args[0]);
	    }
		System.out.println(thing.solveBFS(true));
	}
}

