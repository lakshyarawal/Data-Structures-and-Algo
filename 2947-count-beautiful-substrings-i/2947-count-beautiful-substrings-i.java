class Solution {
    public int beautifulSubstrings(String s, int k) {
        int res = 0;
        Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u'));
        
        for(int i = 0; i < s.length(); i++){
            int countC = 0;
            int countV = 0;
            for(int j = i; j < s.length(); j++){
                char c = s.charAt(j);
                if(vowels.contains(c)){
                    countV++;
                }else{
                    countC++;
                }
                if((countC == countV) && (countC*countV)%k == 0){
                    res++;
                }
            }
        }
        
        return res;
    }
}