class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) return false;
        sum /= 2;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = dp.length-1; i >= n; --i) {
                if (!dp[i]) dp[i] = dp[i - n];
            }
        }
        return dp[sum];
    }
}