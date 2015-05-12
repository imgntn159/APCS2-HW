import java.io.*;
import java.util.*;

public class heapNode {

    private int data;
    private heapNode left,right,parent;

    public heapNode(int d) {
    	data = d;
    	left = right = parent = null;
    }
    
    //accessors
    public T getData() {
	   return data;
    }
    public heapNode getLeft() {
	   return left;
    }
    public heapNode getRight() {
	   return right;
    }
    public heapNode getParent() {
       return parent;
    }

    //mutators
    public void setData(int d) {
	   data = d;
    }
    public void setLeft(heapNode l) {
	   left = l;
    }
    public void setRight(heapNode r) {
	   right = r;
    }
    public void setParent(heapNode p) {
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