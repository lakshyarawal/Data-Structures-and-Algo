class Solution {
    public int lengthOfLongestSubstring(String s) {
        Integer[] count_array = new Integer[128];
        int left = 0;
        int right = 0;
        int max_sub_len = 0;
        while(right < s.length()){
            char r = s.charAt(right);
            Integer index = count_array[r];
            if(index != null && index >= left && index < right) left = index + 1;

            max_sub_len = Math.max(max_sub_len, right- left + 1);

            count_array[r] = right;
            right++;
        }
        return max_sub_len;
    }
}