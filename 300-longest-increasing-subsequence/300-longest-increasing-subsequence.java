class Solution {
    public int lengthOfLIS(int[] nums) {
        // create an array to store the max increasing length till this point of array
        // iterate through all elements smaller than nums[i] and find the max len in above array
        // keep track of the max length found and add one to it for current element
        
        int n = nums.length;
        int[] longestIncYet = new int[n];
        longestIncYet[n-1] = 1;
        int maxSublen = 1;
        
        
        for(int i = n-2; i > -1; i -= 1){
            longestIncYet[i] = 1;
            for(int j = i+1; j < n; j += 1){
                if(nums[j] > nums[i]){
                    longestIncYet[i] = Math.max(longestIncYet[j] + 1, longestIncYet[i]);
                    
                }
            }
            maxSublen = Math.max(maxSublen, longestIncYet[i]);
            
             
        }
        
        return maxSublen;
    }
}