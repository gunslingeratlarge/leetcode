//dont forget to add generic statement
//读题不仔细：only when "C", you have to pop an number
class Solution {
    public int calPoints(String[] ops) {
        MyStack<Integer> ms = new MyStack<Integer>();
        int sum = 0;
      for (String s : ops) {
        if (s.equals("C")) {
          int a = ms.pop();
          sum -= a;
        } else if (s.equals("+")) {
          Integer a = ms.pop();
          Integer b = ms.peek() + a;
          ms.push(a);
          ms.push(b);
          sum += b;
        } else if (s.equals("D")) {
           int a = ms.push(ms.peek() * 2);
          sum += a;
        } else {
        int a = ms.push(Integer.valueOf(s));
        sum += a;
        }
       
      }
       return sum;
    }
}

class MyStack<T> implements Iterable<T>{
  private T[] a;
  private int N;//the number of elements in stack
  
  public MyStack() {
    a = (T[])new Object[1];
  }
  public T pop(){
    if (!isEmpty()){
      T temp = a[--N];
      a[N] = null;
      if(N > 0 && N == a.length / 4) {
        resize(a.length / 2);
      }
      return temp;
    }else{
      return null;
    }
  }
  
  public T push(T item) {
    if (N == a.length) {
      resize(N * 2);
    }
    a[N++] = item; 
    return item;
  }
  
  public boolean isEmpty() {
    return N == 0;
  }
  
  public T peek() {
    if (!isEmpty()) {
      return a[N - 1];
    } else {
      return null;
    }
  }
  
  public void resize(int capacity) {
    T[] b = (T[])new Object[capacity];
    for (int i = 0; i < N; i++){
      b[i] = a[i];
    }
    a = b;
  }
  
  public Iterator<T> iterator() {
    return new ReverseArrayIterator();
  }
  
  private class ReverseArrayIterator implements Iterator<T> {
    private int i = N;
    public boolean hasNext() {
      return i > 0;
    }
    public T next() {
      return a[--i];
    }
  }
  
  
}

