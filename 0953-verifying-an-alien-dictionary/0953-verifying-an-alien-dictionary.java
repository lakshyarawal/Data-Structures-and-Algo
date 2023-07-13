class Solution {
    HashMap<Character, Integer> orderMap;
    
    public boolean compareWords(String first, String second){
        int idx1 = 0, idx2 = 0;
        while(idx1 < first.length() && idx2 < second.length()){
            if(orderMap.get(first.charAt(idx1)) > orderMap.get(second.charAt(idx2))){
                return false;
            } else if( orderMap.get(first.charAt(idx1)) < orderMap.get(second.charAt(idx2))){
                return true;
            }
            idx1++;
            idx2++;
        }
        if(idx1 < first.length()) return false;
        return true;
    }
        
    public boolean isAlienSorted(String[] words, String order) {
        if(words.length == 1 || words.length == 0) return true; 
        orderMap = new HashMap<>();
        for(int i = 0; i < order.length(); i++){
            orderMap.put(order.charAt(i), i);
        }

        for(int j = 1; j < words.length; j++){

            if(!compareWords(words[j-1], words[j])){
                return false;
            }
        }
        return true;
    }
}