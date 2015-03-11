public class LNode implements List{
	private int value;
	private LNode next;

	public int getVal(){
		return value;
	}
	public int setVal(int x){
		value = x;
	}
	
	public LNode getNext(){
		return next;
	}
	public int setNext(LNode thing){
		next = thing;
	}
	public String toString(){
		return String.valueOf(value);
	}
}