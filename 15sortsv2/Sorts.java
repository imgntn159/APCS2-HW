import java.io.*;
import java.util.*;

public class Sorts{
	public static void heapSort(int[] ary){
		heapify(ary.length -1,ary);
	}
	public static void heapify(int index,int[] array){
		int parent = index/2;
		if(index == 0){
			return;
		}
		if(array[index] > array[parent]){
			int temp = array[index];
			array[index] = array[parent];
			array[parent] = temp;
			heapify(parent,array);
		}
	}
	public static void main(String[]args){
		int[] list = new int[] {3,6,8,9,10,15,4,7};
		System.out.println(Arrays.toString(list));
		heapify(list.length-1,list);
		System.out.println(Arrays.toString(list));
	}
}