class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        HashMap<Integer, Integer>[] dp = new HashMap[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new HashMap<>();
        }
        int ans = 2;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                int cnt = dp[j].getOrDefault(diff, 1);
                dp[i].put(diff, 1 + cnt);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
