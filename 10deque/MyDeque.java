import java.util.*;

public class MyDeque<T> {

  private T[] list;
  private int head,tail,size;

  public MyDeque() {
    list = (T[]) (new Object[10]);
    head = 0;
    tail = 9;
    size = 0;
  }

  public boolean add(T item) {
    return true;
  }

  public void addFirst(T item) {
    return;
  }

  public void addLast(T item) {
    return;
  }

  public T getFirst() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return list[head];
  }

  public T getLast() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return list[tail];
  }

  public int size() {
    return size;
  }

  public String toString() {
    return "EMPTY";
  }
}