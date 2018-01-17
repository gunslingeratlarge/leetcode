class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
      int[] output = new int[temperatures.length];
      LinkedStack ls = new LinkedStack();
      for (int i = 0; i < temperatures.length; i++) {
        //find the proper place for every element
        while(!ls.isEmpty() && ls.peek() < temperatures[i]) {
          int smaller = ls.peekIndex();
          output[smaller] = i - smaller;
          ls.pop();
        }
        ls.push(temperatures[i],i);
      }
      return output;
    }
}

class LinkedStack {
  private Node first;
  
  private class Node {
    int val;
    Node next;
    int index;
  }
  
  public void push(int x, int index) {
    if (first == null) {
      first = new Node();
      first.val = x;
      first.next = null;
      first.index = index;
    } else {
      Node node = new Node();
      node.val = x;
      node.index = index;
      node.next = first;
      first = node;
    }
  }
  
  public int pop() {
    Node r = first;
    first = first.next;
    return r.val;
  }
  
  public int peek() {
    return first.val;
  }
  
  public int peekIndex() {
    return first.index;
  }
  
  public boolean isEmpty() {
    return first == null;
  }
}


