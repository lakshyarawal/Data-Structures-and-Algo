class Solution {
    
    public long maximumSubarraySum(int[] nums, int k) {
        
        long maxSum =0;
        long curSum =0;
        int j=0; // points to start of the window
        
        // Key: ArrayValue, value: index
        HashMap<Integer, Integer> map = new HashMap();
        
        for(int i=0;i<nums.length;i++){
            
            curSum += nums[i];
            if(map.containsKey(nums[i])){
                int firstInstance = map.get(nums[i]);
  
                for(int m=j;m<=firstInstance;m++){
                    map.remove(nums[m]);
                    curSum -=nums[m];
                }
                j=firstInstance+1;
            }
            
            map.put(nums[i], i);

            if(map.size() == k){
                maxSum = Math.max(maxSum,curSum);
                // each time size of map == k , remove the first element
                int firstElement = nums[i-k+1];
                curSum -= firstElement;
                map.remove(firstElement);
                j++; // increment window start index
            }             
        }   
        return maxSum;
    }
}