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
            if(j == p.length()-1){
                Boolean isPos = true;
                //System.out.println(Arrays.toString(temp));
                //System.out.println(Arrays.toString(char_count));
                for(int i = 0; i < temp.length; i++){
                    if(temp[i] != char_count[i]) isPos = false;
                }
                if(isPos)indices.add(j-p.length()+1);
            }
            if(j >= p.length()){
                temp[s.charAt(j-p.length()) - 'a']--;
                Boolean isPos = true;
                //System.out.println("Index: "+ j);
                //System.out.println(Arrays.toString(temp));
                //System.out.println(Arrays.toString(char_count));
                for(int i = 0; i < temp.length; i++){
                    if(temp[i] != char_count[i]) isPos = false;
                }
                if(isPos)indices.add(j-p.length()+1);
            }
            
            //System.out.println("Sum for index: "+  Arrays.stream(temp).sum());
        }
        
        return indices;
    }
}