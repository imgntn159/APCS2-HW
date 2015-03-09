import java.util.*;
public class quick{

	public static int partition(int[] L, int start, int end,int index){
		if (start == end){
			return L[start];
		}
		int[] other = new int[L.length];
		for(int i = 0; i < L.length; i++){
			if(i < start || i > end){
				other[i] = L[i];
			}
		}

		Random r = new Random();
		int pivotindex = r.nextInt(end - start + 1) + start;
		int min = start;
		int max = end;

		for(int i = start; i <= end; i++){
			if(L[i] < L[pivotindex]){
				other[min] = L[i];
				min++;
			}else if(L[i] > L[pivotindex]){
				other[max] = L[i];
				max--;
			}
		}
		other[min] = L[pivotindex];

		if(min == index){
			return other[min];
		}
		for(int i = 0; i < L.length; i++){
			L[i] = other[i];
		}
		if(min > index){
			return partition(L,start, min - 1, index);
		}
		return partition(L, min + 1, end, index);
	}

	public static int quickselect(int[] array, int index){
		return partition(array, 0, array.length - 1, index);
	}

	public static void main(String[] args) {
		int[] bleh = {6,2,8,4,5,7,13,200,52};
		System.out.println(Arrays.toString(bleh));
		System.out.println(quickselect(bleh,5));
		Arrays.sort(bleh);
		System.out.println(Arrays.toString(bleh));

	}

}

