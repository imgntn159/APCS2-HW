import java.util.*;

public class mergesort{
	public static int[] merge(int[] a, int[] b){
		int[] result = new int[a.length + b.length];
		return mergeHelp(a,b,0,0,0,result);
    }
    public static int[] mergeHelp(int[] a, int[] b, int aCount, int bCount, int endCount, int[] end){
    	if(aCount >= a.length){
		    for(int i = bCount; i < b.length; i++){
				end[i+endCount-bCount] = b[i];
	    	}
	    	return end;
		}
		if(bCount >= b.length){
		    for(int i = aCount; i < a.length; i++){
				end[i+endCount-aCount] = a[i];
	    	}
	    	return end;
		}

    	if (a[aCount] > b[bCount]){
    		end[endCount] = a[aCount];
    		return mergeHelp(a,b,aCount+1,bCount,endCount+1,end);
    	} else{
    		end[endCount] = b[bCount];
    		return mergeHelp(a,b,aCount,bCount+1,endCount+1,end);
    	}
    }

    public static int[] mergeS(int[] array){
    	if (array.length <= 1){
    		return array;
    	}
    	return merge(mergeS(Arrays.copyOfRange(array,0,array.length / 2)), mergeS(Arrays.copyOfRange(array,array.length / 2, array.length)));
    }

    public static void mergeSort(int[] a){
		int[] b = mergeS(a);
		for(int i = 0; i < a.length; i++){
		    a[i] = b[i];
		}
    }

    /*Driver*/
    public static void main(String[]args){
    	int[] a = new int[]{1,2,3,4,5,6};
    	int[] b = new int[]{6,5,4,3,2,1};
    	int[] c = new int[]{3,4,2,1,6,5};
    	mergeSort(a);
    	System.out.println(Arrays.toString(a));
    	mergeSort(b);
    	System.out.println(Arrays.toString(b));
    	mergeSort(c);
    	System.out.println(Arrays.toString(c));
    }
}