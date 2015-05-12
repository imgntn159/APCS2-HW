public class MyHeap2{
	private boolean isMax;
	private int[] array;
	public MyHeap2(){
		isMax = true;
		array = new int[10];
	}
	public MyHead(boolean thing){
		isMax = thing;
		array = new int[10];
	}
	public String toString(){
		return "hi!";
	}
	private void resize(){
		int[] temp = new int[array.length * 2];
		System.arraycopy(array,0,temp,0,array.length);
		array = temp;
	}
	public int remove(){
		return 1;
	}
	public void add(int val){
		if(array[1] == null){
			array[1] = val;
		}else{
			add(val, 2);
		}
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