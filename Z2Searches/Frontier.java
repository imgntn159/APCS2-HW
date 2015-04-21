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
		MyDeque<Point> temp = list;
		if (list.size() == 0){
			return "[]";
		}
		String result = "";
		result += "[";
		while(size() > 0){
			result+=temp.removeFirst();
			result+=",";
		}
		result+="]";
		//list = temp;
		return result;
	}
	public int size(){
		return list.size();
	}
	public static void main(String[]args){
		Frontier D = new Frontier(false);
		D.add(new Point(2,1));
		D.add(new Point(1,2));
		System.out.println(D.remove());
		D.add(new Point(3,1));
		System.out.println(D.remove());
	}
}