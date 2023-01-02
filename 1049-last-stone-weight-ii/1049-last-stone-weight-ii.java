class Solution {
    public int totalSum;
    public int lastStoneWeightII(int[] stones) {
        totalSum = 0;
        for(int x : stones)
            totalSum += x;
        return helper(stones, 0, 0, new Integer[stones.length+1][stones.length*100+1]);
    }
        public int helper(int[] stones, int index, int currWeight, Integer[][] dp) {
        if(dp[index][currWeight] != null)
            return dp[index][currWeight];
        int ans = 0;
        if(index == stones.length) ans = Math.abs(2 * currWeight - totalSum);
        else 
            ans = Math.min(
                            helper(stones, index+1, currWeight, dp),
                            helper(stones, index+1, currWeight+stones[index], dp)
                            );
        return dp[index][currWeight] = ans;
    }
}