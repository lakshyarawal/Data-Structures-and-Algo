class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int st = 0;
        int end = nums.length - 1;
        int k = ans.length - 1;
        while(st<=end){
            if((Math.abs(nums[st]) < Math.abs(nums[end]))){
                ans[k--] = nums[end]*nums[end];
                end--;
            }
            else{
                ans[k--] = nums[st]*nums[st];
                st++;
            }
        }
        return ans;
    }
}