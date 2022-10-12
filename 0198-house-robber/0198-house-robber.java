class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int j = 0;
        int curr_loot = nums[j];
        int curr_loot2 = nums[j+1];
        int max_loot = Math.max(curr_loot, curr_loot2);
        for(int i=2; i< nums.length; i++){
            if(i%2 == 0){
               curr_loot2 = Math.max(curr_loot, curr_loot2);
                curr_loot += nums[i];
                max_loot = Math.max(max_loot, curr_loot);
            }
            else{
                curr_loot = Math.max(curr_loot, curr_loot2);
                curr_loot2 += nums[i];
                max_loot = Math.max(max_loot, curr_loot2);
            }
            j++;
        }
        return max_loot;
    }
}