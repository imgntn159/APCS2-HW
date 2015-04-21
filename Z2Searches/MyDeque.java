import java.util.*;
import java.io.*;

public class MyDeque<T> {

  private T[] list;
  private int[] p;
  private int head,tail,size;

  public MyDeque() {
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

  public void add(T item, int pr){
    resize();

    int temp = 0;
    for(int i = head; i < p.length + head;i++){
      if(pr > p[i % p.length]){
        temp = i % p.length;
        break;
      }
    }
    tail = (list.length + (tail + 1))%list.length;
    int j = tail;
    while(j > temp){
      p[j] = p[j - 1];
      list[j] = list[j - 1];
      j--;
    }
    p[temp] = pr;
    list[temp] = item;

    size++;
  }

  public T removeFirst(){
    T val = list[head];
    list[head] = null;
    head++;
    if(head != 0 && head >= list.length){
      head -= list.length;
    }
    size--;
    return val;
  }
  public T removeLast(){
    T val = list[tail];
    list[tail] = null;
    tail--;
    if(tail < 0){
      tail += list.length;
    }
    size--;
    return val;
  }

  public T removeSmallest(){
    return removeFirst();
  }
  public T removeLargest(){
    return removeLast();
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
    MyDeque<Point> D = new MyDeque<Point>();
    D.add(new Point(2,1),0);
    D.add(new Point(1,2),0);
    System.out.println(D.removeFirst());
    D.add(new Point(3,1),0);
    System.out.println(D.removeFirst());
  }
}