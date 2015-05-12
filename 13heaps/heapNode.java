import java.io.*;
import java.util.*;

public class HeapNode {

    private int data;
    private HeapNode left,right,parent;

    public HeapNode(int d) {
    	data = d;
    	left = right = parent = null;
    }
    public HeapNode(int d, HeapNode p){
        data = d;
        parent = p;
        left = right = null;
    }
    
    //accessors
    public int getData() {
	   return data;
    }
    public HeapNode getLeft() {
	   return left;
    }
    public HeapNode getRight() {
	   return right;
    }
    public HeapNode getParent() {
       return parent;
    }

    //mutators
    public void setData(int d) {
	   data = d;
    }
    public void setLeft(HeapNode l) {
	   left = l;
    }
    public void setRight(HeapNode r) {
	   right = r;
    }
    public void setParent(HeapNode p) {
       parent = p;
    }

    //orphanage
    public boolean hasNoChildren(){
        return left==null && right==null;
    }
    public boolean hasChildren(){
        return !hasNoChildren();
    }

    public String toString(){
    	return data.toString();
    }
}