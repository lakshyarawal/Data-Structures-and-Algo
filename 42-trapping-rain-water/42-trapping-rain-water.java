class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxNow = new int[n];
        maxNow[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i -= 1){
            maxNow[i] = Math.max(height[i], maxNow[i+1]);
        }
        
        int totalWater = 0;
        int maxLeft = height[0];
        
        for(int j = 1; j < n-1; j += 1){
            if(Math.min(maxLeft, maxNow[j+1]) - height[j] > 0){
                totalWater += Math.min(maxLeft, maxNow[j]) - height[j];
            }
            maxLeft = Math.max(maxLeft, height[j]);
            
        }
        return totalWater;
    }
}