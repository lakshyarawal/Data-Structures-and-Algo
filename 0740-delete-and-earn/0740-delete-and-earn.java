class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums.length ==0){
            return 0;
        }
        int maxNum = Integer.MIN_VALUE;
        for(int el: nums){
            maxNum = Math.max(maxNum, el);
        }
        int [] freq =  new int[maxNum + 1]; 
        for(int el: nums){
           freq[el] += el;
        }

        int[] dp = new int[freq.length];
        dp[0] = 0;
        dp[1] = freq[1];
        for(int i = 2; i< freq.length; i++)
            dp[i] = Math.max(freq[i] + dp[i-2], dp[i-1]);

        return dp[freq.length-1];
        
    }
}