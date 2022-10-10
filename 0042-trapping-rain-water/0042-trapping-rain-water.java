class Solution {
    public int trap(int[] height) {
        int left_max = height[0];
        int right_max[] = new int[height.length];
        right_max[height.length-1] = height[height.length-1];
        for (int j = height.length-2; j >= 0; j--){
            right_max[j] = Math.max(height[j], right_max[j+1]);
        }
        int res = 0;
        for(int i=1; i< height.length-1; i++){  
            if(height[i] < left_max && height[i] < right_max[i]){
                res += Math.min(left_max, right_max[i]) - height[i];
            }
            left_max = Math.max(left_max, height[i]);
        }
        return res;
    }
}