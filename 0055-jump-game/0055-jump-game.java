class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if(n == 1) return true;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 0; i < n; i++){
            if(dp[i] != 1) continue;
            for(int j = i; j <= i + nums[i] && j < n; j++){
                dp[j] = 1;
            }
        }
        if(dp[n-1] == 0) return false;
        return true;
    }
}