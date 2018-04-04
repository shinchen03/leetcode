class MinStack {
        public element top;

    /** initialize your data structure here. */
    public MinStack() {
        
    }
    
    public void push(int x) {
        if (top == null) {
            top = new element(x,x);
        } else {
            element e = new element(x, Math.min(x, top.min));
            e.next = top;
            top = e;
        }
    }
    
    public void pop() {
        if (top == null) {
            return;
        }
        element temp = top.next;
        top.next = null;
        top = temp;
    }
    
    public int top() {
        if (top == null) {
            return -1;
        }
        return top.value;
    }
    
    public int getMin() {
        if (top == null) {
            return -1;
        }
        return top.min;
    }
    
}

class element {
    public int value;
    public int min;
    public element next;

    public element (int value, int min) {
        this.value = value;
        this.min = min;
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