class Solution {
    public int numberOfGoodSubarraySplits(int[] nums) {
        long ans = 1, m = 1000000007, count  = 0;
        int i = 0;
        while(i < nums.length && nums[i] == 0) ++i;
        if(i >= nums.length) return 0;
        while(i < nums.length){
            if(nums[i] == 1){  ans = (ans * (count +1 ))%m;  count = 0; }
            else count++;
            i++;
        }
        return (int) ans;
    }
}