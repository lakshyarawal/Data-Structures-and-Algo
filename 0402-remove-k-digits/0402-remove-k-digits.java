class Solution {
    public String removeKdigits(String num, int k) {        
        if(k >= num.length()) return "0";

        Deque<Character> stack = new ArrayDeque<>();
        for(char c : num.toCharArray()) {
            while(k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.removeLast();
                k--;
            }
            stack.addLast(c);
        }
        
        while(k>0) {
            stack.removeLast();
            k--;
        }
        
        // Remove all zeros from the front of the stack and then if stack is empty, return "0"
        while(!stack.isEmpty() && stack.peekFirst()== '0') stack.removeFirst();
        if(stack.isEmpty()) return "0";

        // build the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        return sb.toString();
    }
}