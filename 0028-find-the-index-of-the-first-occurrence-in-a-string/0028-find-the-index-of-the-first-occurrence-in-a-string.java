class Solution {
    public int strStr(String haystack, String needle) {
        StringBuilder sb = new StringBuilder();
        if(needle.length() > haystack.length()) return -1;
        for(int i = 0; i < needle.length(); i++){
            sb.append(haystack.charAt(i));
        }
        if(sb.toString().equals(needle)) return 0;
        for(int i = needle.length(); i< haystack.length(); i++){
            sb.append(haystack.charAt(i));
            sb.deleteCharAt(0);
            if(sb.toString().equals(needle)) return i-needle.length()+1;
        }
        
        return -1;
    }
}