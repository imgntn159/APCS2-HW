import java.util.*;
public class MyLinkedList<T> implements Iterable<T>{

	public class LinkedIterator<T> implements Iterator<T>{
		private LNode<T> head;
		public LinkedIterator(LNode<T> node){
			head = node;
		}
		public boolean hasNext(){
			return head.getData() != null;
		}
		public T next(){
			if (head.getData() != null){
				T temp = head.getData();
				head = head.getNext();
				return temp;
			}else{
				throw new NoSuchElementException();
			}
		}
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}

	private LNode<T> head;
	private int size;

	public String name(){
		return "castanos.kaizen";
	}

	public LNode<T> getHead(){
		return head;
	}

	public String toString(){
		if(size() == 0){
			return "[ ]";
		}
		String ans = "[";
		LNode<T> temp = head;
		while(temp.getNext() != null){
			ans += "" + temp.getData() + ",";
			temp = temp.getNext();
		}
		ans += "" + temp.getData() + "]";
		return ans;
	}

    public void add(T n){//Adds to end
    	if (size() == 0){
    		head = new LNode<T>(n);
    	}else{
    		LNode<T> temp = head;
    		for (int i = 0; i < size() - 1; i++){
    			temp = temp.getNext();
    		}
    		temp.setNext(new LNode<T>(n));
    	}
    	size++;
    }
    public void add(int index, T value){
    	if(index == 0){
    		LNode<T> bleh = new LNode<T>(value,head);
    		head = bleh;
    	}else{
    		LNode<T> temp = head;
    		for (int i = 0; i < index - 1; i++){
    			temp = temp.getNext();
    		}
    		LNode<T> blarg = new LNode<T>(value,temp.getNext());
    		temp.setNext(blarg);
    		size++;
    	}
    }

    public T get(int index){
    	LNode<T> temp = head;
    	for (int i = 0;i < index;i++){
    		try{
    			temp = temp.getNext();
    		}catch(IndexOutOfBoundsException e){
    			System.out.println("You suck, pick a better index");
    			return null;
    		}
    	}
    	return temp.getData();
    }
    public void set(int index, T value){
    	LNode<T> temp = head;
    	for (int i = 0; i < index; i++){
    		try{
    			temp = temp.getNext();
    		}catch(IndexOutOfBoundsException e){
    			System.out.println("You suck, pick a better index");
    			return;
    		}
    	}
    	temp.setData(value);
    }
    public int indexOf(T value){
    	int n = 0;
    	LNode<T> temp = head;
    	for (int i = 0; i < size(); i++){
    		if(temp.getData() == value){
    			return n;
    		}
    		temp = temp.getNext();
    		n++;
    	}
    	return -1;
    }
    public boolean remove(int index){
    	if(index == 0){
    		head = head.getNext();
    	}else{
    		int n = 0;
    		LNode<T> temp = head;
    		for (int i = 0; i < index - 1; i++) {
    			head = head.getNext();
    		}
    		try{
    			temp.setNext(temp.getNext().getNext());
    		}catch(NullPointerException e){
    			temp.setNext(null);
    		}
    	}
    	size--;
    	return true;
    }

    public int size(){
    	return size;
    }

    public Iterator<T> iterator(){
    	return new LinkedIterator<T>(head);
    }

    public static void main(String[] args){
    	MyLinkedList<Integer> l = new MyLinkedList<Integer>();
    	l.add(1);
    	l.add(2);
    	System.out.println(l);
    	l.remove(1);
    	System.out.println(l);
    	System.out.println("/****/");
	/*MyLinkedList<String> s = new MyLinkedList<String>();
	  s.add("a");
	  s.add("b");
	  System.out.println(s);
	  s.add(1,"c");
	  System.out.println(s);*/
	}
}