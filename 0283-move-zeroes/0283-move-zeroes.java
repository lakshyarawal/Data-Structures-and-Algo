class Solution {
    public void moveZeroes(int[] nums) {
        int lastNonZero = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) continue;
            else if(nums[i] != 0){
                lastNonZero++;
                nums[lastNonZero] = nums[i];
            }
        }
        lastNonZero++;
        for(int  i =lastNonZero; i < nums.length; i++){
            nums[i] = 0;
        }
    }
}