class Solution {
    public int[] getChar(String s){
        int[] count = new int[26];
        for(char c : s.toCharArray()){
            count[c-'a']++;
        }
        return count;
    }
    public boolean compareCount(int[] c1, int[] c2){
        for(int i = 0; i < c1.length; i ++){
            if(c1[i] != c2[i]) return false;
        }
        return true;
    }
    
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())return false;
        if(s1.length() == s2.length()) return compareCount(getChar(s2), getChar(s1));
        int sSize = s1.length();
        int[] prev = getChar(s2.substring(0, sSize));
        int[] res = getChar(s1);
        if(compareCount(prev, res)) return true;
        //System.out.println("Prev: " +s2.substring(0, sSize));
        for(int i = sSize; i < s2.length(); i++){
            prev[s2.charAt(i-sSize)-'a']--;
            prev[s2.charAt(i)-'a']++;
            if(compareCount(prev, res)) return true;
        }
        return false;
    }
}