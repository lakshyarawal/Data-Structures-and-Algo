class Solution {
    public int maxArea(int[] height) {
        int total_area = 0;
        int left_p = 0;
        int right_p = height.length-1;
        while(left_p < right_p){
            total_area = Math.max(total_area, Math.min(height[left_p], height[right_p])*(right_p - left_p));
            if(height[left_p] > height[right_p]){
                right_p--;
            }
            else{
                left_p++;
            }
        }
        return total_area;
    }
}