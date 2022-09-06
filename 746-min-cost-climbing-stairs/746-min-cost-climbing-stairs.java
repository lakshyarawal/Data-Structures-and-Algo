class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] sumArray = new int[cost.length];
        sumArray[0] = cost[0];
        sumArray[1] = cost[1];
        for(int i = 2; i<cost.length; i ++){
            sumArray[i] = Math.min(sumArray[i-1], sumArray[i-2]) + cost[i];
        }
        return Math.min(sumArray[cost.length-1], sumArray[cost.length-2]) ;
    }
}