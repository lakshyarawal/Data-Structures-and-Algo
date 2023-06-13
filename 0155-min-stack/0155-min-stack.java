class MinStack {

private Stack<Integer> minimums;
private Stack<Integer> stack;

/** initialize your data structure here. */
public MinStack() {
    minimums = new Stack<Integer>();
    stack = new Stack<Integer>();
}

public void push(int val) {
    // if we have a minimum and the new value is smaller than the current minimum
    if ( !minimums.isEmpty() && val <= minimums.peek() )
    {
        minimums.push(val);
    }
    // if this is the first value
    else if ( minimums.isEmpty() )
    {
        minimums.push(val);
    }
    stack.push(val);
}

public void pop() {
    // if what we're popping is the current minimum
    if ( (int)stack.peek() == (int)minimums.peek() )
    {
        minimums.pop();
    }
    stack.pop();
}

public int top() {
    return stack.peek();
}

public int getMin() {
    return minimums.peek(); 
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