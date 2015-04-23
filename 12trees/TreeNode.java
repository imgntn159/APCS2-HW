public class TreeNode<T>{
	private T data;
	private TreeNode<T> left = null;
	private TreeNode<T> right = null;
	
	public TreeNode(){
		data = null;
	}
	public TreeNode(T data){
		this.data = data;
	}

	public T getData(){
		return data;
	}
	public boolean hasData(){
		return data != null;
	}
	public TreeNode<T>  getLeft(){
		return left;
	}
	public TreeNode<T>  getRight(){
		return right;
	}

	public boolean hasLeft(){
		return left != null; 
	}
	public boolean hasRight(){
		return right != null;
	}

	public void setData(T item){
		data = item;
	}
	public void setLeft(T item){
		if(hasLeft()){
			left.setData(item);
		}else{
			left = new TreeNode<T>(item);
		}
	}
	public void setRight(T item){
		if(hasRight()){
			right.setData(item);
		}else{
			right = new TreeNode<T>(item);
		}
	}

	public String toString(){
		return "" + data;
	}
}