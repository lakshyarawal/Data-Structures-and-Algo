class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();
        for(String c : tokens){
            //System.out.println(c);
            if(c.equals("+") || c.equals("-") || c.equals("/") || c.equals("*")){
                int a =0, b=0;
                if(!s.isEmpty()){
                    a = Integer.valueOf(s.pop());
                }
                if(!s.isEmpty()){
                    b = Integer.valueOf(s.pop());
                }
                int res = 0;
                
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
                s.push(String.valueOf(res));
            }
            else{
                s.push(c);
            }
        }
        //System.out.println(Arrays.toString(s.toArray()));
        return Integer.valueOf(s.pop());
    }
}