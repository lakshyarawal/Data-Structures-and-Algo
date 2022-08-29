import java.util.Arrays;

class Solution {

    
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int lastIndex = n-1;
        
        for(int i = n-2; i>= 0; i --){
            int furthestIndex = Math.min(n-1, nums[i] + i);
            for(int j = i + 1; j <= furthestIndex; j += 1){
                if(j == lastIndex){
                    lastIndex = i;
                    break;
                }
            }
            
        }
        
        if(lastIndex == 0){
            return true;
        }
        
        return false;
        
    }
    
}