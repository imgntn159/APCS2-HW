public class LNode<T>{
	private T value;
	private LNode<T> next;

	public String name(){
	    return "Castanos.Kaizen";
	}

	public LNode(T val){
		setData(val);
	}
	public LNode(T val,LNode<T> thingy){
		setData(val);
		setNext(thingy);
	}

	public T getData(){
		return value;
	}
	public void setData(T x){
		value = x;
	}
	
	public LNode<T> getNext(){
		return next;
	}
	public void setNext(LNode<T> thing){
		next = thing;
	}
	public String toString(){
		return String.valueOf(value);
	}
}