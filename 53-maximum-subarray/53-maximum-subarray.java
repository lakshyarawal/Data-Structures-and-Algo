class Solution {
    public int maxSubArray(int[] nums) {
        int curr_sum = nums[0];
        int largestSum = nums[0];
        for(int i = 1; i < nums.length; i += 1){
            if(nums[i] > curr_sum + nums[i]){
                curr_sum = nums[i];
            }
            else{
                curr_sum += nums[i]; 
            }
            if(curr_sum > largestSum){
                    largestSum = curr_sum;
                }
        }
        return largestSum;
    }
}