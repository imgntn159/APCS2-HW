public class MyHeap{
	private boolean isMax;
	private HeapNode root;
	public MyHeap(){
		isMax = true;
	}
	public MyHead(boolean thing){
		isMax = thing;
	}
	public String toString(){
		return "hi!";
	}
	public int remove(){
		return 1;
	}
	public void add(int val){
		add(val, root);
	}
	private void add(int val, HeapNode node){
		if(valChecker(val,node.getData())){
			if(node.hasNoChildren()){
				node.setLeft(new HeapNode(val,node));
			}else{
				node.setRight(new HeapNode(val,node));
			}
		}
	}
	private boolean valChecker(int a, int b){
		if(isMax){
			return a<b;
		}else{
			return b<a;
		}
	}
	public int peek(){
		return 1;
	}
}