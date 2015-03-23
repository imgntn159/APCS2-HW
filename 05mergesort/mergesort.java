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
		    a[a.length - 1 - i] = b[i];
		}
    }

    /*Driver*/
    public static void main(String[]args){
    	try{
	    int[] a = new int[Integer.toInteger(args[0])];
	    long s = System.currentTimeMillis();
	    mergeSort(a);
	    long e = System.currentTimeMillis();
	    System.out.println("That was " + (s-e) + " milliseconds");
	}catch (Exception e){
	    System.out.println("Put in a number =P");
	}
    }
}