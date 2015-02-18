public class Driver{
    public static void main(String[]args){
        int size = 0;
		try{
	    	size = Integer.parseInt(args[0]);
		}catch(Exception e){
	    	size = 5;
		}
		KnightsTour a = new KnightsTour(size);
		System.out.println(a.solve(0,0,1));
		System.out.println(a);
    }
}
