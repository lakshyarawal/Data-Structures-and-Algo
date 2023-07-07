class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String currentLCP = strs[0];
        int lcpLength = strs[0].length();
        
        HashMap<Integer, Character> lcpMap = new HashMap<>();
        for(int j = 0; j < strs[0].length(); j++){
            lcpMap.put(j, strs[0].charAt(j));
        }
        
        for(int i = 1; i < strs.length; i++){
            int newLcpLength = 0;
            for(int j = 0; j < strs[i].length() && j <= lcpLength; j++){
                if(lcpMap.containsKey(j) && strs[i].charAt(j) == lcpMap.get(j)){
                    newLcpLength++;
                }else{
                    break;
                }
            }
            lcpLength = Math.min(lcpLength, newLcpLength);
            if(lcpLength == 0) return "";
        }
        
        return currentLCP.substring(0, lcpLength);
    }
}