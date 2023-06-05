class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
    
        Arrays.fill(jumps, Integer.MAX_VALUE);
        int steps = Integer.MAX_VALUE;
        jumps[0] = 0;
        
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length && j <= i + nums[i]; j++){
                
                jumps[j] = Math.min(jumps[j], 1 + jumps[i]);
                
                if(j == nums.length - 1){
                    steps = Math.min(jumps[j], steps);
                }
                
            }
        }
        
        return steps;
    }
}