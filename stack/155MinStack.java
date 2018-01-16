class MinStack {
  //first is the bottom element of the stack
    private Node first;
  
    private class Node {
      int val;
      Node next;
      int curMin;// when this node is the last one, its curMin = min
    }
    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if(first == null){
          first = new Node();
          first.val = x;
          first.curMin = x;
        } else {
          Node node = new Node();
          node.val = x;
          if ( x < first.curMin ) {
            node.curMin = x;
          } else {
            node.curMin = first.curMin;
          }
          node.next = first;
          first = node;
        }
    }
    
    public void pop() {
        first = first.next;
    }
    
    public int top() {
        return first.val;
    }
    
    public int getMin() {
        return first.curMin;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */