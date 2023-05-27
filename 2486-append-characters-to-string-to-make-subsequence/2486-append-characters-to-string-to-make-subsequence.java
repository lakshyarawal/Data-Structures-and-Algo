class Solution {
    public int appendCharacters(String s, String t) {
        
        int m = t.length();
        int curr_index = 0;
        
        for(int i = 0; i< s.length(); i++){
            if(s.charAt(i) == t.charAt(curr_index)){
                curr_index++;
                if(curr_index == m){
                    return 0;
                }
            }
        }
        
        return m - curr_index;
    }
}