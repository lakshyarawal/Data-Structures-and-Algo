class Solution {
    public boolean isPalindrome(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString().equals(s);
    }
    
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                if(isPalindrome(s.substring(start+1, end+1)) || isPalindrome(s.substring(start, end))) return true;
                else return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}