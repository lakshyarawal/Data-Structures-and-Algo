class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int num = 2; num < n+1; num++){
            dp[num] = (num == n) ? 0 : num;
            for(int i = 1; i < num; i++){
                int val = dp[i] * dp[num-i];
                dp[num] = Math.max(dp[num], val);
            }
        }
        //System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}