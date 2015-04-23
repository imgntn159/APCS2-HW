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
    private void add(T item, TreeNode<T> node){
	if(!(node.hasLeft())){
	    node.setLeft(item);
	}else if(!(node.hasRight())){
	    node.setRight(item);
	}else{
	    if(rand.nextBoolean()){
		add(item,node.getLeft());
	    }else{
		add(item,node.getRight());
	    }
	}
    }


    public int getHeight(){
	return getHeight(root,0);//Just the root means height==0
    }
    public int getHeight(TreeNode<T> node,int count){
	if(!(node.hasLeft()) && !(node.hasRight())){
	    return count;
	}else if(getHeight(node.getLeft(),count+1) > getHeight(node.getRight(),count+1)){
	    return getHeight(node.getLeft(),count+1);
	}else{
	    return getHeight(node.getRight(),count+1);
	}
    }
    public String toString(){
	return "dummy string";
    }
    public void traverse(int i){//0 is pre, 1 is in, 2 is post
	return;
    }
}