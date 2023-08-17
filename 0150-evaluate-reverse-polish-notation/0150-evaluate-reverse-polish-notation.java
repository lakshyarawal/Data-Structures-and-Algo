class Solution {
    private Stack<String> s;
    
    private int calculate(String c){
        int a =0, b=0, res = 0;
        
        if(!s.isEmpty()) a = Integer.valueOf(s.pop());
        if(!s.isEmpty()) b = Integer.valueOf(s.pop());

        switch (c) {
          case "+":
            res = a+b;
            break;
          case "-":
            res = b-a;
            break;
          case "/":
            res = b/a;
            break;
          case "*":
            res = b*a;
            break;
        }
        return res;  
    }
    
    public int evalRPN(String[] tokens) {
        s = new Stack<>();
        for(String c : tokens){
            if(c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")) s.push(String.valueOf(calculate(c)));
            else s.push(c);
        }
        return Integer.valueOf(s.pop());
    }
}