public class MyHeap{
	private boolean isMax;
	private int[] array;
	public MyHeap(){
		isMax = true;
		array = new int[10];
	}
	public MyHead(boolean thing){
		isMax = thing;
		array = new int[10];
	}
	public String toString(){
		String result = "";
		for(int i : array){
			result += Integer.toString(i) + " ";
		}
		return result;
	}
	private void resize(){
		int[] temp = new int[array.length * 2];
		System.arraycopy(array,0,temp,0,array.length);
		array = temp;
	}
	public int remove(){
		int temp = array[1];
		reorder(1);
		array[0] -= 1;
		return temp;
	}
	public void add(int val){
		int index = 0;
		boolean full = false;
		for(int i = 1;i<array.length;i++){
			if(array[i] == null){
				array[i] = val;
				index = i;
				break;
			}else if(i == array.length -1){
				full = true;
				index = i;
			}
		}
		if(full){resize(); array[index] = val;}
		reorder(index);
		array[0] += 1;
	}
	private void reorder(int i){
		
	}
	private void add(int val, int index){
		if(array[index] == null){
			array[index] = val;
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
		if(array[1] == null){
			return 0;
		}
		return array[1];
	}
}