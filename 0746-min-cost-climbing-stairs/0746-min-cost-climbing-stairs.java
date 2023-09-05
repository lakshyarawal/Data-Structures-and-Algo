class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return 0;
        if(n == 1) return cost[0];
        int minCostTwoBefore = cost[0];
        int minCostOneBefore = cost[1];
        for(int i = 2; i < n; i++){
            int minCost = Math.min(minCostTwoBefore, minCostOneBefore) + cost[i];
            minCostTwoBefore = minCostOneBefore;
            minCostOneBefore = minCost;
        }
        return Math.min(minCostTwoBefore, minCostOneBefore);
    }
}