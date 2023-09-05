class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0) return 0;
        if(n == 1) return cost[0];
        int[] minCost = new int[n];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i = 2; i < n; i++){
            minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];
        }
        return Math.min(minCost[n-1], minCost[n-2]);
    }
}