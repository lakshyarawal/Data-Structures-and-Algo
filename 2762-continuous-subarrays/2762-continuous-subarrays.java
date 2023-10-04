class Solution {
    public long continuousSubarrays(int[] nums) {
        int i = 0;              // Left pointer of the sliding window
        int j = 0;              // Right pointer of the sliding window
        int n = nums.length;    // Length of the input array
        long res = 0;           // Result variable to count continuous subarrays
        TreeMap<Integer, Integer> map = new TreeMap<>(); // TreeMap to keep track of element frequencies

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // Check if the maximum difference within the window is greater than 2
            while (map.lastEntry().getKey() - map.firstEntry().getKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++; // Shrink the window from the left
            }

            // Update the result with the count of valid subarrays within the window
            res += j - i + 1;

            j++; // Expand the window from the right
        }

        return res;
    }
}