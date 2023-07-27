class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = 1_000_000_000;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (operations(nums, mid) > maxOperations)
                left = mid + 1;
            else
                right = mid;
        }
        return left;
    }

    private int operations(int[] nums, int mid) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / mid;
        }

        return operations;
    }
}