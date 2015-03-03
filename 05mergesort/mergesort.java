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
    		return mergeHelp(a,b,aCount+1,bCount,endCount+1,end;)
    	} else if (a[aCount] > b[bCount]){
    		end[endCount] = b[bCount];
    		return mergeHelp(a,b,aCount,bCount+1,endCount+1,end;)
    	}
    }

    public static int[] mergeSort(int[] array){
    	if (array.length <= 1){
    		return array;
    	}
    	int[] a = new int[array.length / 2];
		int[] b = new int[array.length - (array.length / 2)];
		for(int i = 0; i < a.length; i++){
	    	a[i] = array[i];
		}
		for(int i = a.length - 1; i < array.length; i++){
	    	b[i - a.length / 2] = array[i];
		}
		return merge(mergeSort(a),mergeSort(b));
    }

    public static void mergeSort(int[] a){
		int[] b = mergeSort(a);
		for(int i = 0; i < a.length; i++){
		    a[i] = b[i];
		}
    }

    /*Driver*/
    public static void main(String[]args){
    	System.out.println("HI");
    	//put stuff here
    }
}