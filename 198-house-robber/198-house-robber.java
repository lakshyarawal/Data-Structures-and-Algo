class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] maxRob = nums;
        int totalRob = nums[0];
        if(n > 1){
            totalRob = Math.max(nums[0], nums[1]);
        }
        if(n > 2){
            maxRob[2] = maxRob[0] + maxRob[2];
            totalRob = Math.max(maxRob[2], totalRob);
        }
        for(int i = 3; i < n; i += 1){

            maxRob[i] = Math.max(nums[i-2], nums[i-3]) + nums[i];
            totalRob = Math.max(maxRob[i], totalRob);
        }
        
        return totalRob;
        
    }
}