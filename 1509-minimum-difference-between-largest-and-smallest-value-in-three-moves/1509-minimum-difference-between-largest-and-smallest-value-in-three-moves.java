class Solution {
    public int minDifference(int[] nums) {
        
        int len = nums.length;
        if (len <= 4) return 0;
        Arrays.sort(nums);

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, nums[len - 1 - 3 + i] - nums[i]);
        }
        return res;
    }
}