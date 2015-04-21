import java.util.*;
import java.io.*;

public class MyDeque<T> {

  private ArrayList<T> list;
  private ArrayList<Integer> p;
  private int head,tail,size;

  public MyDeque() {
    list = new ArrayList<T>();
    p = new ArrayList<Integer>();
  }

  public void add(T item, int pr){
    list.add(item);
    p.add(pr);
  }

  public T removeLast(){
    p.remove(0);
    return list.remove(0);
  }
  public T removeFirst(){
    p.remove(list.size() - 1);
    return list.remove(list.size() - 1);
  }

  public T removeSmallest(){
    int temp = p.get(0);
    int in = 0;
    for (int i = 0; i < list.size();i++){
      if(p[i] < temp){
        temp = p.get(i);
        in = i;
      }
    }
    p.remove(in);
    return list.remove(in);
  }
  public T removeLargest(){
    int temp = p.get(0);
    int in = 0;
    for (int i = 0; i < list.size();i++){
      if(i > temp){
        temp = p.get(i);
        in = i;
      }
    }
    p.remove(in);
    return list.remove(in);
  }

  public T getFirst(){
    return list.get(0);
  }

  public T getLast(){
    return list.get(list.size() - 1);
  }

  public int size(){
    return list.size();
  }

  public static void main(String[]args){
    MyDeque<Point> D = new MyDeque<Point>();
    D.add(new Point(2,1,0),0);
    D.add(new Point(1,2,0),1);
    System.out.println(D.removeSmallest());
    D.add(new Point(3,1,0),0);
    System.out.println(D.removeFirst());
  }
}