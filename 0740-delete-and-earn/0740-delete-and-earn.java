class Solution {
    public int deleteAndEarn(int[] nums) {
        int value[] = new int[10001];
        for(int i=0; i<nums.length; i++){
            value[nums[i]] += nums[i];
        }
        int prev1, prev2;
        prev1 = prev2 = 0;
        for(int i=0; i<value.length; i++){
            int dp = Math.max(prev1, prev2 + value[i]);
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;
    }
}