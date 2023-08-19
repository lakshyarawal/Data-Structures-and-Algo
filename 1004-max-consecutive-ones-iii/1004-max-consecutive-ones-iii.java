class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int maxLength = 0;
        while(end < nums.length){
            if(nums[end] == 1){
                end++;
            }else if(nums[end] == 0 && k > 0){
                end++;
                k--;
            }else{
                if(nums[start] == 0) k++;
                start++;
            }
            maxLength = Math.max(end-start, maxLength);
        }
        maxLength = Math.max(end-start, maxLength);
        return maxLength;
    }
}