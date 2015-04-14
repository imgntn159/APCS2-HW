import java.util.*;

public class MyDequeP<T> {

  private T[] list;
  private int[] p;
  private int head,tail,size;

  public MyDequeP() {
    list = (T[]) new Object[10];
    p = new int[10];
    head = 0;
    tail = 9;
    size = 0;
  }

  public void resize(){
    if(size == list.length){
      T[] newlist = (T[]) new Object[size * 2];
      int[] newp = new int[size * 2];
      for(int i = 0; i < size; i++){
        newlist[i] = list[(head + i) % size];
	newp[i] = p[(head + i) % size];
      }
      list = newlist;
      p = newp;
      head = 0;
      tail = size - 1;
    }
  }

  public void addFirst(T item, int pr){
    resize();
    head--;
    if(head < 0){
      head += list.length;
    }
    list[head] = item;
    p[head] = pr;
    size += 1;
  }
  public void addLast(T item, int pr){
    resize();
    tail++;
    if(tail != 0 && tail >= list.length){
      tail -= list.length;
    }
    list[tail] = item;
    p[tail] = pr;
    size += 1;
  }

  public T removeFirst(){
    T val = list[head];
    list[head] = null;
    head++;
    if(head != 0 && head >= list.length){
      head -= list.length;
    }
    size -= 1;
    return val;
  }
  public T removeLast(){
    T val = list[tail];
    list[tail] = null;
    tail--;
    if(tail < 0){
      tail += list.length;
    }
    size -= 1;
    return val;
  }

  public T removeSmallest(){
      T val;
      int pr = p[0];
      int in = 0;
      for(int i = 0; i < size; i++){
	  if (p[i] < pr){
	      in = i;
	      pr = p[i];
	  }
      }
      val = list[in];
      list[in] = null;
      p[in] = null;
      size-= 1;
      return val;
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
    MyDequeP<Integer> D = new MyDequeP<Integer>();
    for (int i = 1;i < 26;i++){
      D.addFirst(i);
    }
    System.out.println(D.size());
    System.out.println(D.removeLast());
    System.out.println(D.removeLast());
    System.out.println(D.size());
  }
}