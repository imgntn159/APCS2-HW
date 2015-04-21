public class Frontier{
	MyDeque<Point> list = new MyDeque<Point>();
	private int behavior;// if true, then q

	public boolean hasNext(){
		return list.size() > 0;
	}

	public Frontier(int behavior){
		this.behavior = behavior;
	}
	public void add(Point item){
		list.add(item,0);
	}
	public void add(Point item,int pr){
		list.add(item,pr);
	}
	public Point remove(){
		if(behavior==0){//BFS
			return list.removeLast();
		}else if (behavior==1){//DFS
			return list.removeFirst();
		}else{//Best or AStar
			return list.removeLargest();
		}
	}
	public static void main(String[]args){
		Frontier D = new Frontier(1);
		D.add(new Point(2,1,0));
		D.add(new Point(1,2,0));
		System.out.println(D.remove());
		D.add(new Point(3,1,0));
		System.out.println(D.remove());
	}
}