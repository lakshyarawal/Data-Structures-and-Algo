class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < i; j++){
                int a = (i-j) * j;
                int b = dp[i-j] * j;
                int c = dp[i];
                dp[i] = Math.max(a, Math.max(b, c));
            }
        }
        return dp[n];
    }
}