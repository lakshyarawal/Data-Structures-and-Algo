class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int maxVal = 0;
        
        for (int n: nums) 
		{
            hm.put(n, (hm.getOrDefault(n, 0) + 1));
            maxVal = Math.max(maxVal, n);
        }
        
        int[] dp = new int[maxVal+1];
        dp[1] = 1 * hm.getOrDefault(1, 0);
        
        for (int i = 2; i <= maxVal; i++) 
            dp[i] = Math.max(dp[i-1], dp[i-2] + i * hm.getOrDefault(i, 0));
        
        return dp[maxVal];
    }
}