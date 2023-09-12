class Solution {
    public boolean isLeave(String s1, String s2, String s3, int a, int b, int c, Boolean[][] memo) {
        // Check if we have reached the end of all strings
        if (a == s1.length() && b == s2.length() && c == s3.length()) return true;
        
        // Check if we have already computed this subproblem
        if (memo[a][b] != null) return memo[a][b];
        
        boolean result = false;
        
        // Check if s1 character matches s3 character
        if (a < s1.length() && s1.charAt(a) == s3.charAt(c)) {
            result |= isLeave(s1, s2, s3, a + 1, b, c + 1, memo);
        }
        
        // Check if s2 character matches s3 character
        if (b < s2.length() && s2.charAt(b) == s3.charAt(c)) {
            result |= isLeave(s1, s2, s3, a, b + 1, c + 1, memo);
        }
        
        // Store the result in memoization table
        memo[a][b] = result;
        
        return result;
    }
    
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        
        Boolean[][] memo = new Boolean[s1.length() + 1][s2.length() + 1];
        return isLeave(s1, s2, s3, 0, 0, 0, memo);
    }
}
