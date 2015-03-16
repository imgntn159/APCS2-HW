import java.util.*;
public class MyLinkedList<T>{
	private LNode head;
	private int size;

	public String name(){
	    return "castanos.kaizen";
	}

	public LNode getHead(){
		return head;
	}

	public String toString(){
		if(size() == 0){
			return "[ ]";
		}
		String ans = "[";
		LNode temp = head;
		while(temp.getNext() != null){
			ans += "" + temp.getVal() + ",";
			temp = temp.getNext();
		}
		ans += "" + temp.getVal() + "]";
		return ans;
	}

	public void add(T n){
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

	public int get(int index){
		LNode temp = head;
		for (int i = 0;i < index;i++){
			try{
				temp = temp.getNext();
			}catch(IndexOutOfBoundsException e){
				System.out.println("You suck, pick a better index");
				return 0;
			}
		}
		return temp.getVal();
	}
	public void set(int index, int value){
		LNode temp = head;
		for (int i = 0; i < index; i++){
			try{
				temp = temp.getNext();
			}catch(IndexOutOfBoundsException e){
				System.out.println("You suck, pick a better index");
				return;
			}
		}
		temp.setVal(value);
	}
	public int indexOf(int value){
		int n = 0;
		LNode temp = head;
		for (int i = 0; i < size(); i++){
			if(temp.getVal() == value){
				return n;
			}
			temp = temp.getNext();
			n++;
		}
		return -1;
	}

	public int size(){
		return size;
	}

	public static void main(String[] args){
		MyLinkedList l = new MyLinkedList();
		l.add(1);
		l.add(2);
		System.out.println(l);
		l.add(1,3);
		System.out.println(l);
	}
}