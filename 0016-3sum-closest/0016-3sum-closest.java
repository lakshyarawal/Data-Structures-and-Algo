
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array to optimize the two-pointer approach
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize the closest sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1; // Pointer from the next element
            int right = nums.length - 1; // Pointer from the last element

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return target; // Found an exact match, return the target sum
                }

                // Update the closest sum if the current sum is closer to the target
                if (Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    left++; // Move the left pointer to increase the sum
                } else {
                    right--; // Move the right pointer to decrease the sum
                }
            }
        }

        return closestSum;
    }
}