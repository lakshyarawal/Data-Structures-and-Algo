class Solution 
{
    public long maximumSubarraySum(int[] nums, int k) 
    {
        Long res = 0L, cur = 0L, dup = -1L;
        int[] pos = IntStream.range(0, 100001).map(j -> -1).toArray();
        
        for (int i = 0; i < nums.length; ++i)
        {
            cur += nums[i];
            if (i >= k) cur -= nums[i-k];
            
            dup = Math.max(dup, pos[nums[i]]);
            if (i - dup >= k) res = Math.max(res, cur);
            
            pos[nums[i]] = i;
        }
        
        return res;
    }
}