public class MyStack<T>{
  private LNode<T> top;
  public MyStack(){
    return;
  }
  public T peek(){
    return top.getData();
  }
  public T pop(){
    T temp = top.getData();
    top = top.getNext();
    return temp;
  }
  public T push(T item){
    LNode<T> temp = new LNode<T>(item);
    temp.setNext(top);
    top = temp;
    return item;
  }

  public static void main(String[]args){
    MyStack<Integer> S = new MyStack<Integer>();
    S.push(1);
    S.push(4);
    System.out.println(S.peek()); //4
    System.out.println(S.pop());  //4
    System.out.println(S.peek()); //1
  }
}