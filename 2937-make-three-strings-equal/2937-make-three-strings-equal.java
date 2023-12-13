class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        int minLength = Math.min(l1, Math.min(l2, l3)); 
        for(;i < minLength; i++){
            if(s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) continue;
            else break;
        }
        return i==0 ? -1 : (l1 + l2 + l3 - (i*3));
    }
}