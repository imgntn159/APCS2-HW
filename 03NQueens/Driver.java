public class Driver{
    public static void main(String[]args){
        int size = 0;
		try{
	    	size = Integer.parseInt(args[0]);
		}catch(Exception e){
	    	size = 4;
		}
		NQueens a = new NQueens(size);
		System.out.println(a.solve());
		System.out.println(a);
    }
}
