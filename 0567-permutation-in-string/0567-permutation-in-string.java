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
        if(s1.length() > s2.length())checkInclusion(s2, s1);
        int sSize = s1.length();
        for(int i = 0; i <= s2.length() - sSize; i++){
            //System.out.println("Comparing: "+ s2.substring(i, i+sSize));
            if(compareCount(getChar(s2.substring(i, i+sSize)), getChar(s1))) return true;
        }
        return false;
    }
}