class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;
        
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length())); 
        for(;i < minLength; i++){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) continue;
            else break;
        }
        return i==0 ? -1 : (s1.length() + s2.length() + s3.length() - (i*3));
    }
}