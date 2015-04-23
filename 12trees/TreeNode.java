public class TreeNode<T>{
	private T data;
	private TreeNode<T> left = new TreeNode<T>();
	private TreeNode<T> right = new TreeNode<T>();
	
	public TreeNode(){
		data = null;
	}
	public TreeNode(T data){
		this.data = data;
	}

	public T getData(){
		return data;
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
		left.setData(item);
	}
	public void setRight(T item){
		right.setData(item);
	}

	public String toString(){
		return "" + data;
	}
}