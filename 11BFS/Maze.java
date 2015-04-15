import java.util.*;

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
	asdf;
    }

    /**Solve the maze using a frontier in a DFS manner. 
     * When animate is true, print the board at each step of the algorithm.
     * Replace spaces with x's as you traverse the maze. 
     */
    public boolean solveDFS(boolean animate){
	
    }

    public boolean solveBFS(){
	return solveBFS(false);
    }
    public boolean solveDFS(){
	return solveDFS(false);
    }
    /*private boolean solve(boolean animate, boolean mode){
	    Frontier rest = new Frontier(mode);
	    Point start = new Point(startx,starty);//startx and starty are instance variables in my maze class

	    rest.add(start);//put the start into the Frontier 
		
	    boolean solved = false;
	    while(!solved && rest.hasNext()){
		if(animate && !solved){
		    System.out.println(toString(true));
		}
		    //get the top
		Point next = rest.remove();
		    //check if solved
		if(maze[next.getX()][next.getY()]=='E'){
			//solved!
		    solved = true;
		    addCoordinatesToSolutionArray(next);

			//my point class has a reference to previous points, so the solution will be determined from the final point

		}else{
			//not solved, so add neighbors to Frontier and mark the floor with x.
		    maze[next.getX()][next.getY()]='x';
		    for(Point p : getNeighbors(next)){
			rest.add(p);
		    }

		}
	    }
	    return solved;
	    }*/
}

