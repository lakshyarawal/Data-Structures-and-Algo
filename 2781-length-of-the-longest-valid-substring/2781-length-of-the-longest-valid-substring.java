class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        int curr = 0;
        
        
        
        Set<String> forbidSet = new HashSet<>(forbidden);
        
        int ans = 0;
        
        for(int i = n - 1; i >= 0; i--){
            StringBuilder sb = new StringBuilder();
            int len = 0;
            int prev = curr;
            for(int j = i; j < Math.min(n, i + 10); j++){
                sb.append(word.charAt(j) + "");
                if(forbidSet.contains(sb.toString())){
                    break;
                }
                len++;
            }
            
            if(len >= 10) len = n - i;
            
            curr = Math.min(1 + prev, len);
            ans = Math.max(ans, curr);
        }
        
        return ans;
    }
}