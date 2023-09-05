class Solution {
    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        int[] maxRobbed = new int[n];
        maxRobbed[0] = nums[0];
        maxRobbed[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            maxRobbed[i] = Math.max(maxRobbed[i - 1], maxRobbed[i - 2] + nums[i]);
        }
        return maxRobbed[n - 1];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);
        
        int[] subarray1 = new int[n - 1];
        int[] subarray2 = new int[n - 1];
        
        // Copy elements from the original array to the subarrays
        System.arraycopy(nums, 0, subarray1, 0, n - 1);
        System.arraycopy(nums, 1, subarray2, 0, n - 1);
        
        return Math.max(rob1(subarray1), rob1(subarray2));
    }
}
