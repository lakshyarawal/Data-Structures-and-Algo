class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long left = 0;
        long right = 0;
        int minDif = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            right+= nums[i];
        }
        
        int ind = -1;
        
        for(int i = 0; i< n; i++){
            left += nums[i];
            long li = left/(i+1);
            long ri = right - left;
            if(i != n-1){
                 ri = ri/(n-i-1);
            }
          
            //System.out.println("Left: "+ li);
            //System.out.println("Right: "+ ri);
            
            if((int) Math.abs(li - ri) < minDif){
                ind = i;
                minDif = (int) Math.abs(li - ri);
            }
            //System.out.println("Min Dif: "+ minDif);
        }
        
        
        return ind;
    }
}