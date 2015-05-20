import java.io.*;
import java.util.*;

public class Sorts{
	public static void heapSort(int[] ary){
		for(int i = ary.length-1;i>=0;--i){
			heapify(i,ary);
		}
		//theActualSort(ary);
	}
	public static void heapify(int index,int[] array){
		int parent = (index-1)/2;
		if(index == 0){
			return;
		}
		if(array[index] > array[parent]){
			int temp = array[index];
			array[index] = array[parent];
			array[parent] = temp;
		}
	}
	public static void pushDown(int index,int end,int[] array){
		if((2*index) + 1 >= end){
			return;
		}else if (array[index] < array[(2*index) + 2]) {
      int temp = array[index];
			array[index] = array[(2*index) + 2];
			array[(2*index) + 2] = temp;
      pushDown((2*index) + 2,end,array);
    }else if (array[index] < array[(2*index) + 1]) {
      int temp = array[index];
			array[index] = array[(2*index) + 1];
			array[(2*index) + 1] = temp;
      pushDown((2*index) + 1,end,array);
    }
	}
	private static void theActualSort(int[] array){
		for (int i = 0; i < array.length; ++i) {
      int temp = array[0];
			array[0] = array[array.length-1-i];
			array[array.length-1-i] = temp;
      pushDown(0,array.length-1-i,array);      
    }
	}
	public static void main(String[]args){
		int[] list = new int[] {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(list));
		heapSort(list);
		System.out.println(Arrays.toString(list));
	}
}