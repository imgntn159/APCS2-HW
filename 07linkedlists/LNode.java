public class LNode{
	private int value;
	private LNode next;

	public LNode(int val){
		setVal(val);
	}
	public LNode(int val,LNode thingy){
		setVal(val);
		setNext(thingy);
	}

	public int getVal(){
		return value;
	}
	public void setVal(int x){
		value = x;
	}
	
	public LNode getNext(){
		return next;
	}
	public void setNext(LNode thing){
		next = thing;
	}
	public String toString(){
		return String.valueOf(value);
	}
}