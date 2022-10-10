class Solution {
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length - 1;
        int left_max = 0;
        int right_max = 0;
        while (start < end) {
            if (height[start] < height[end]) {
                if(height[start] >= left_max) {
                    left_max = height[start];
                }
                else{
                    result += left_max - height[start];
                }
                ++start;
            } else {
               if(height[end] >= right_max) {
                    right_max = height[end];
                }
                else{
                    result += right_max - height[end];
                }
                --end;
            }
        }
        return result;
    }
}