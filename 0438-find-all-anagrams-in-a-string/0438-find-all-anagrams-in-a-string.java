class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if(p.length() > s.length()) return indices;
        
        int[] char_count = new int[26];
        
        for(int i = 0; i < p.length(); i++){
            char_count[p.charAt(i) - 'a']++;
        }
        
        int[] temp = new int[26];
        
        for(int j = 0; j < s.length(); j++){
            temp[s.charAt(j) - 'a']++;
            Boolean isPos = true;
            if(j > p.length()-1){
                temp[s.charAt(j-p.length()) - 'a']--;
            }
            if(j > p.length() - 2){
                for(int i = 0; i < temp.length; i++){
                    if(temp[i] != char_count[i]) isPos = false;
                }
                if(isPos)indices.add(j-p.length()+1);
            }

        }
        return indices;
    }
}