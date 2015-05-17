public class MyHeap{
	private boolean isMax;
	private int[] array;
	public MyHeap(){
		isMax = true;
		array = new int[10];
	}
	public MyHeap(boolean thing){
		isMax = thing;
		array = new int[10];
	}
	public String toString(){
		String result = "";
		for(int i : array){
			if(i == 0){
				result += " " + " ";
			}else{
				result += Integer.toString(i) + " ";
			}
		}
		return result;
	}
	private void resize(){
		int[] temp = new int[array.length * 2];
		System.arraycopy(array,0,temp,0,array.length);
		array = temp;
	}
	public int remove(){
		int index = 1;
		int temp = array[1];
		array[1] = 0;
		for(int i = 2;i<array.length;i++){
			if(i == array.length - 1){
				index = i;
			}else if(array[i] == 0){
				index = i-1;
			}
		}
		removeh(index);
		array[0]--;
		return temp;
	}
	private void removeh(int index){
		int parent = 1;
		if(index%2 == 0){
			parent = index/2;
		}else{
			parent = (index-1)/2;
		}
		if(valChecker(array[index],array[parent])){
			int temp = array[index];
			array[index] = array[parent];
			array[parent] = temp;
			removeh(parent);
		}
	}
	public void add(int val){
		int index = 0;
		boolean full = false;
		for(int i = 1;i<array.length;i++){
			if(array[i] == 0){
				array[i] = val;
				index = i;
				break;
			}else if(i == array.length -1){
				full = true;
				index = i;
			}
		}
		if(full){resize(); array[index] = val;}
		addh(index);
		array[0]++;
	}
	private void addh(int index){
		int parent = 1;
		if(index%2 == 0){
			parent = index/2;
		}else{
			parent = (index-1)/2;
		}
		if(valChecker(array[index],array[parent])){
			int temp = array[index];
			array[index] = array[parent];
			array[parent] = temp;
			addh(parent);
		}
	}
	private boolean valChecker(int a, int b){
		if(isMax){
			return a<b;
		}else{
			return b<a;
		}
	}
	public int peek(){
		if(array[1] == 0){
			return 0;
		}
		return array[1];
	}
	public static void main(String[]args){
		MyHeap h = new MyHeap();
		//h.add(4);
		h.add(3);
		h.add(2);
		h.add(1);
		System.out.println(h);
		//System.out.println(h.peek());
		//System.out.println(h.remove());
		//System.out.println(h);
	}
}