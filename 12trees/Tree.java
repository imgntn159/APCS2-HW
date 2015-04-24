import java.util.*;
import java.io.*;

public class Tree<T>{
    private TreeNode<T> root = new TreeNode<T>();
    private Random rand = new Random(1);
    public Tree(){
	return;
    }
    public void add(T item){
	if(!(root.hasData())){
	    root.setData(item);
	}else{
	    add(item,root);
	}
    }
    private void add(T item, TreeNode<T> node){
	if(!(node.hasLeft())){
	    node.setLeft(item);
	}else if(!(node.hasRight())){
	    node.setRight(item);
	}else{
	    if(node.getLeft().hasLeft() && node.getLeft().hasRight()){
		add(item,node.getRight());
	    }else{
		add(item,node.getLeft());
	    }
	}
    }
    /*HEIGHTS AND LEVELS*/
    public int getHeight(){
	return getHeight(root,-1);//Just the root means height==1, weirdly enough
    }
    public int getHeight(TreeNode<T> node){
	return getHeight(node,-1);
    }
    private int getHeight(TreeNode<T> node,int count){
	if(node == null){
	    return count;
	}else if(getHeight(node.getLeft(),count+1) > getHeight(node.getRight(),count+1)){
	    return getHeight(node.getLeft(),count+1);
	}else{
	    return getHeight(node.getRight(),count+1);
	}
    }
    private String getLevel(TreeNode<T> curr, int level, int currLevel){
	String result = "";
	if(level < currLevel){
	    System.out.println("WHAT ARE YOU DOING FOOL");
	    return "";
	}
	if (level == currLevel){
	    return "" + curr.getData() + " ";
	}
	if(curr.hasLeft()){
	    result += getLevel(curr.getLeft(),level,currLevel + 1);
	}
	if(curr.hasRight()){
	    result += getLevel(curr.getRight(),level,currLevel + 1);
	}
	return result;
    }


    public String toString(){
	String result = "";
	for(int i = 0;i<=getHeight();i++){
	    result += getLevel(root,i,0);
	    result += "\n";
	}
	return result;
    }

    /*public String toString(){
	return toString1();
	String result = "";
	double asdf = Math.pow(2,getHeight()); 
	int spaces = (int)asdf - 1;
	System.out.println(spaces);
	for(int i = 0;i<=getHeight();i++){
	    String level = getLevel(root,i,0);
	    System.out.println(level);
	    int a = (spaces - level.length())/2;
	    int b = level.length();
	    for(int q = 0;q < a;q++){
		result += "_";
	    }
	    result += level;
	    for (int q = 0;q < spaces-a-b;q++){
		result += "_";
	    }
	    result += "\n";
	}
	return result;
	}*/
	

    /*TRAVERSAL*/
    public String traverse(int mode){//0 is pre, 1 is in, 2 is post
  	if(mode==0){
	    return preOrder(root);
  	}else if(mode==1){
	    return inOrder(root);
  	}else{
	    return postOrder(root);
  	}
    }
    private String preOrder(TreeNode<T> node){
  	String result = "";
	result+=node.getData()+",";
  	if(node.hasLeft()){
	    result += preOrder(node.getLeft());
  	}
  	if(node.hasRight()){
	    result += preOrder(node.getRight());
  	}
  	return result;
    }
    private String inOrder(TreeNode<T> node){
  	String result = "";
  	if(node.hasLeft()){
	    result += inOrder(node.getLeft());
  	}
  	result+=node.getData()+",";
  	if(node.hasRight()){
	    result += inOrder(node.getRight());
  	}
  	return result;
    }
    private String postOrder(TreeNode<T> node){
  	String result = "";
  	if(node.hasLeft()){
	    result += postOrder(node.getLeft());
  	}
  	if(node.hasRight()){
	    result += postOrder(node.getRight());
  	}
  	result+=node.getData()+",";
  	return result;
    }

    /*MAIN FUNCTION*/
    public static void main(String[]args){
  	Tree<Integer> thing = new Tree<Integer>();
  	thing.add(1);
  	thing.add(2);
  	thing.add(3);
  	thing.add(4);
  	thing.add(5);
  	thing.add(6);
  	thing.add(7);
  	System.out.println(thing);
	System.out.println(thing.getHeight());
    }
}