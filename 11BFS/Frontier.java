public class Frontier{
    MyDeque<Point> list = new MyDeque<Point>();
    private boolean behavior;// if true, then q

    /*public class DeqIterator implements Iterator{
	public boolean hasNext(){
	    return list.size() > 0;
	}
	public int next(){
	    return 3;
	}
	public void remove(){
	    throw new UnsupportedOperationException();
	}
	}*/

    public boolean hasNext(){
	return list.size() > 0;
    }

    public Frontier(boolean behavior){
	this.behavior = behavior;
    }
    public void add(Point item){
	list.addFirst(item);
    }
    public Point remove(){
	if(behavior){
	    return list.removeLast();
	}else{
	    return list.removeFirst();
	}
    }
}