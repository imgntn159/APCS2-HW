public class MyLinkedList /*implements List?*/{
    private LNode head;
    public LNode getHead(){
	return head;
    }
    public string toString(){
	if(head.getVal() == null){
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
    public int get(int index){
	LNode temp = head;
	for (int i = 0;i < index;i++){
	    try{
		temp = temp.getNext();
	    }catch(IndexOutOfboundsException e){
		System.out.println("You suck, pick a better index");
		return;
	    }
	}
	return temp.getVal();
    }
}