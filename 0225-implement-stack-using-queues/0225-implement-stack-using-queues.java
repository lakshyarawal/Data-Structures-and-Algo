class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.offer(x);
    }
    
    public int pop() {
        if(q1.isEmpty()) return -1;
        if(q1.size() == 1) return q1.remove();
        while(q1.size() > 1){
            q2.offer(q1.remove());
        }
        int res = q1.remove();
        while(q2.size() > 0){
            q1.offer(q2.remove());
        }
        return res;
    }
    
    public int top() {
        if(q1.isEmpty()) return -1;
        if(q1.size() == 1) return q1.peek();
        int res = 0;
        while(q1.size() > 0){
            if(q1.size() == 1){
                res =  q1.peek();
            }
            q2.offer(q1.remove());
        }
        
        while(q2.size() > 0){
            q1.offer(q2.remove());
        }
        return res;
    }
    
    public boolean empty() {
        return q1.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */