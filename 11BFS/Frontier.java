public class Frontier{
	MyDeque<Point> list = new MyDeque<Point>();
	private boolean behavior;// if true, then q

	public boolean hasNext(){
		return list.size() > 0;
	}

	public Frontier(boolean behavior){
		this.behavior = behavior;
	}
	public void add(Point item){
		list.add(item,0);
	}
	public Point remove(){
		if(behavior){
			return list.removeLast();
		}else{
			return list.removeFirst();
		}
	}
	public String toString(){
		if (list.size() == 0){
			return "[]";
		}
		String result = "";
		result += "[";
		while(list.size() > 1){
			result+=list.removeFirst();
			result+=","; 
		}
		result+=list.removeFirst();
		result+="]";
		return result;
	}
	public int size(){
		return list.size();
	}
}