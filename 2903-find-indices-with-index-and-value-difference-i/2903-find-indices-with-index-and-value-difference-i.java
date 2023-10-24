class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int[] ans = new int[]{-1,-1};
        
        List<int[]> list = new ArrayList<>();
        int min = 0;
        int max = 0;
        
        
        //store the max and min till the index i
        for(int i =0;i < nums.length; ++i){
            
            if(nums[i] < nums[min]) min = i;
            if(nums[i] > nums[max]) max = i;
            list.add(new int[]{min, max});
        }
        
        //try to find the second index where the condition can be satisfied
        for(int i =0; i < nums.length; ++i){
            
            int j = i-indexDifference;
            
            if(j>=0){
                
               if(Math.abs(nums[i] - nums[list.get(j)[0]])>=valueDifference){
                   return new int[]{list.get(j)[0], i};
               } 
                
               if(Math.abs(nums[i] - nums[list.get(j)[1]])>=valueDifference){
                   return new int[]{list.get(j)[1], i};
               }  
                    
            }
            
        }
        

        // We can't satisfy the condition
        return new int[]{-1,-1};
    }
}