import java.util.Arrays;

class Solution {
    int[] precomputeSteps;
    
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        precomputeSteps = new int[n];
        
        Arrays.fill(precomputeSteps, 0);
        precomputeSteps[n-1] = 1;
        
        for(int i = n-2; i>= 0; i --){
            int furthestIndex = Math.min(n-1, nums[i] + i);
            for(int j = i + 1; j <= furthestIndex; j += 1){
                if(precomputeSteps[j] == 1){
                    precomputeSteps[i] = 1;
                    break;
                }
            }
            
        }
        
        if(precomputeSteps[0] == 1){
            return true;
        }
        
        return false;
        
    }
    
}