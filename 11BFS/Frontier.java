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
}