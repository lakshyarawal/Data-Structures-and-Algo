class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, maxLength = 0;
        while(end < nums.length){
            if(nums[end] == 1){
                end++;
                maxLength = Math.max(end-start, maxLength);
            }
            else if(nums[end] == 0 && k > 0){
                end++;
                k--;
                maxLength = Math.max(end-start, maxLength);
            }else{
                if(nums[start] == 0) k++;
                start++;
            }
        }
        return maxLength;
    }
}