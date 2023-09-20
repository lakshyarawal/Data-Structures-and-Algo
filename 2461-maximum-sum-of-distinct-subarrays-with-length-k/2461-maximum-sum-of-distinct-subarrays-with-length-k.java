class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
		int start = 0, end = 0;
		long sum = 0, max = 0;
		Set<Integer> set = new HashSet<>();
		while (end < n) {
			int val = nums[end];
			while (set.contains(val) || (end - start + 1 > k) && start < end) {
				sum -= nums[start];
				set.remove(nums[start++]);
			}
			sum += val;
			set.add(val);
			if (end - start + 1 == k)
				max = Math.max(max, sum);
			end++;
		}
		return max;
    }
}