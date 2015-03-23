public class MyQueue<T>{
  private MyLinkedList<T> top;
  public MyQueue(){
    top = new MyLinkedList<T>();
  }
  public T dequeue(){
    LNode<T> temp = top.getHead();
    top.setHead(top.getHead().getNext());
    return temp.getData();
  }
  public boolean enqueue(T item){
    top.add(item);
    return true;
  }
  public static void main(String[]args){
    MyQueue<Integer> Q = new MyQueue<Integer>();
    Q.enqueue(2);
    Q.enqueue(4);
    System.out.println(Q.dequeue());
    System.out.println(Q.dequeue());
  }
}