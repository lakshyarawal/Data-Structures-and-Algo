class Solution {
    public int lengthOfLastWord(String s) {
        String[] s_arr = s.split(" ");
        return s_arr[s_arr.length - 1].length();
    }
}