class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = Map.of(')', '(', '}', '{', ']', '[');
        for(char c : s.toCharArray()){
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.isEmpty()) return false;
            else if(stack.pop() != map.get(c)) return false;
        }
        return stack.isEmpty();
    }
}