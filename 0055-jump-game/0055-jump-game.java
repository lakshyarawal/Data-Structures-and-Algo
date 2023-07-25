

class Solution {

    
    public boolean canJump(int[] nums) {
        int lastIndex = nums.length-1;
        
        for(int i = nums.length-2; i>= 0; i --){
            if(i + nums[i] >= lastIndex){
                lastIndex = i;
            }
            
            }
            
        
        
        if(lastIndex == 0){
            return true;
        }
        
        return false;
        
    }
    
}