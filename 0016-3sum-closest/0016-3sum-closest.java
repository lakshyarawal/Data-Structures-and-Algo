class Solution {
 public int threeSumClosest(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE; //Diff
        result[1] = Integer.MIN_VALUE;//sum
        if (nums == null || nums.length < 3) {
            return result[1];
        } 
        
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int[] temp = new int[2];
            temp[0] = result[0];
            temp[1] = result[1];
            twoSumClosest(nums, i + 1, nums.length - 1, target - nums[i], temp);
            if (temp[0] < result[0]) {
                temp[1] += nums[i];
                result = temp;
            }
            if(result[0] == 0) {
                break;
            }
        } 
        return result[1];
    }
    
    private void twoSumClosest(int[] nums, int start, int end, int target, int[] result) {
        int left = start;
        int right = end;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < target) {
                if (target - sum < result[0]) {
                    result[0] = target - sum;
                    result[1] = sum;
                }
                left++;
            } else if (nums[left] + nums[right] > target) {
                if (sum - target < result[0]) {
                    result[0] = sum - target;
                    result[1] = sum;
                } 
                right--;
            } else {
                result[0] = 0;
                result[1] = target;
                break;
            }
        }
    }
}