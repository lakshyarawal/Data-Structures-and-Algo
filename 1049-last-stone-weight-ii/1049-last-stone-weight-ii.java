class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalSum = 0;
        int n = stones.length;
        for(int s : stones){
            totalSum += s;
        }
        boolean[] dp = new boolean[totalSum/2 + 1];
        dp[0] = true;
        int max_sum = 0;
        for(int s : stones){
            boolean[] temp = dp.clone();
            for(int c = s; c <= totalSum/2; c++){
                if(dp[c - s]){
                    temp[c] = true;
                    max_sum = Math.max(max_sum, c);
                    if(c == totalSum/2) return totalSum - 2*c;
                }
            }
            dp = temp;
        }
        return totalSum -2 * max_sum;
            
    }
}