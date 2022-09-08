class Solution {
    public boolean isSubsequence(String s, String t) {
        // Iterate s to find 1 occurance in t check for other letters
        // If not found iterate the next i in t after where 1 occ was found
        //return true/false based on the result
        int sub_len = 0;
        if(s.length() == 0){
            return true;
        }
        int j = 0;
        for(int i= 0; i < s.length(); i++){
            while(j < t.length()){
                
                if(s.charAt(i) == t.charAt(j)){
                    j++;
                    sub_len ++;
                    if(sub_len == s.length()){
                        return true;
                    }
                    break;
                }
                j++;
                
            }
        }
        return false;
    }
}