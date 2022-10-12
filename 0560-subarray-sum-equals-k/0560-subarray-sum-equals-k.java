class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hash_map = new HashMap();
        int res = 0;
        int prefix_sum = 0;
        hash_map.put(0, 1);
        for(int i: nums){
            prefix_sum += i;
            res += hash_map.getOrDefault(prefix_sum-k, 0);
            hash_map.put(prefix_sum, hash_map.getOrDefault(prefix_sum, 0)+1);
        }
        return res;
    }
}