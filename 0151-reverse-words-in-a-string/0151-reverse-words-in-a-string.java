class Solution {
    
    public String trim(String s){
        int i = 0;
        while(s.charAt(i) == ' '){
            i++;
        }
        int j = s.length()-1;
        while(s.charAt(j) == ' '){
            j--;
        }
        return s.substring(i, j+1);
    }
    
    public String reverseWords(String s) {
        if(s.length() == 1) return s;
        
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        s = trim(s);
        //System.out.println("S"+s+"E");
        sb.append(s.charAt(0));
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) == ' ' && s.charAt(i-1) == ' '){
                continue;
            }
            else if(s.charAt(i) == ' '){
                stack.add(sb.toString());
                sb = new StringBuilder();
            } else{
                sb.append(s.charAt(i));
            }
        }
        stack.add(sb.toString());
        StringBuilder res = new StringBuilder();
        while(!stack.isEmpty()){
            res.append(stack.pop());
            if(!stack.isEmpty()) res.append(" ");
        }
        return res.toString();
    }
}