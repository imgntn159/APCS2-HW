import java.util.*;
import java.io.*;

public class Tree<T>{
	private TreeNode<T> root;
	private Random rand = new Random();
	public Tree(){
		root = null;
	}
	public void add(T item){
		add(item,root);
	}
	public add(T item, TreeNode<T> node){
		if(!(node.hasLeft()){
			node.setLeft(new TreeNode<T>(item));
		}else if(!(node.hasRight()){
			node.setRight(new TreeNode<T>(item));
		}else{
			if(rand.nextBoolean()){
				add(item,node.getLeft());
			}else{
				add(item,node.getRight());
			}
		}
	}
	public String toString(){
		return printer(0);
	}
	public String printer(int i){//0 is pre, 1 is in, 2 is post
		return "dummy string";
	}
}