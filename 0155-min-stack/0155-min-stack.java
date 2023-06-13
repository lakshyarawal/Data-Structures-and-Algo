class MinStack {

    private int size = 0;
    private int capacity = 900;
    private int[] minsBuffer;
    private int[] buffer;
    public MinStack() {
        buffer = new int[capacity];
        minsBuffer = new int[capacity];
    }
    
    public void push(int val) {
        if(isFull()) {
            return;
        }
        
        if(isEmpty()) {
            
            minsBuffer[size] = val;
        }
        else {
            if (val < minsBuffer[size - 1]) {
                minsBuffer[size] = val;
            }
            else {
                minsBuffer[size] = minsBuffer[size - 1];
            }
        }
        buffer[size] = val;
        size++;
    }
    private boolean isEmpty() {
        return size == 0;
    }
    private boolean isFull() {
        return size == capacity;
    }
    public void pop() {
        if(isEmpty()) {
            return;
        }
        size--;
    }
    
    public int top() {
        return buffer[size - 1];
    }
    
    public int getMin() {
        return minsBuffer[size - 1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */