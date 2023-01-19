class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> indices = new ArrayList<>();
        if(p.length() > s.length()) return indices;
        
        int[] char_count = new int[26];
        for(int i = 0; i < p.length(); i++){
            char_count[p.charAt(i) - 'a']++;
        }
        for(int j = 0; j < s.length() - p.length() + 1; j++){
            //System.out.println("Checking for index: "+ j);
            int[] temp = char_count.clone();
            for(int i = j; i < j+p.length(); i++){
                //System.out.println("Checking for char: "+ s.charAt(i) + " val: " +  temp[s.charAt(i) - 'a']);
                temp[s.charAt(i) - 'a']--;
            }
            Boolean isPos = true;
            for(int k : temp){
                if(k != 0) isPos = false;
            }
            if(isPos)indices.add(j);
            //System.out.println("Sum for index: "+  Arrays.stream(temp).sum());
        }
        
        return indices;
    }
}