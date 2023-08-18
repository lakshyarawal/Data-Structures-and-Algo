class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        for(int i = 0; i < s.length(); i++){
            int c1 = expandCenter(s, i, i);
            int c2 = expandCenter(s, i, i+1);
            int len = Math.max(c1, c2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            } 
        }
        return s.substring(start, end+1);
    }
    public int expandCenter(String s, int lo, int hi){
        while(lo >= 0 && hi < s.length() && s.charAt(lo) == s.charAt(hi)){
            lo--;
            hi++;
        }
        return hi - lo - 1;
    }
}