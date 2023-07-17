class Solution {
	
	public boolean checkSubarraySum (int[] nums, int k) {
		
		int sum = 0;
		HashMap<Integer, Integer> map = new HashMap <>();
		map.put (0, -1);
		
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			sum = k == 0 ? sum : sum % k;
			if (map.containsKey (sum) && i - map.get (sum) != 1) {
				return true;
			}
			map.put (sum, map.getOrDefault (sum, i));
		}
		
		return false;
	}
}