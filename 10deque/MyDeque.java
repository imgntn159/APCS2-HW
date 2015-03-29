import java.util.*;

public class MyDeque<T> {

  private T[] list;
  private int head,tail,size;

  public MyDeque() {
    list = (T[]) new Object[10];
    head = 0;
    tail = 9;
    size = 0;
  }

  public void resize(){
    return;
  }

  public void addFirst(T item){
    //resize();
    head--;
    if(head < 0){
      head += list.length;
    }
    list[head] = item;
    size += 1;
  }
  public void addLast(T item){
    //resize();
    tail++;
    if(tail != 0 && tail >= list.length){
      tail -= list.length;
    }
    list[tail] = item;
    size += 1;
  }

  public void removeFirst(T item){
    return;
  }
  public void removeLast(T item){
    return;
  }

  public T getFirst(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return list[head];
  }

  public T getLast(){
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return list[tail];
  }

  public int size(){
    return size;
  }

  public static void main(String[]args){
    MyDeque<Integer> D = new MyDeque<Integer>();
    D.addFirst(1);
    D.addLast(2);
    System.out.println(D.getFirst());
  }
}