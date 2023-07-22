class Solution {
    public String removeDuplicates(String s, int k) {
        if(s.length() < k) return s;
        
        Stack<Pair<Character, Integer>> d = new Stack<>();
        StringBuilder sb = new StringBuilder();
        
        d.push(new Pair(s.charAt(0), 1));
        
        for(int i = 1; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(!d.isEmpty() && c == d.peek().getKey()){
                if(d.peek().getValue() == k-1) d.pop();
                else d.push(new Pair(c, d.pop().getValue()+1));
            }
            else d.push(new Pair(c, 1));
        }
        
        while(!d.isEmpty()){
            Pair<Character, Integer> p = d.pop();
            char c = p.getKey();
            int val = p.getValue();
            while(val > 0){
                sb.append(c);
                val--;
            }
        }
        
        return sb.reverse().toString();
    }
}