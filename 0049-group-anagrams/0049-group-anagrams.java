class Solution {
    
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sortedStr = new String[strs.length];
        for(int i = 0 ; i < strs.length; i++){
            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            sortedStr[i] = new String(tempArray);
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> finalResult = new ArrayList<>();
        for(int i = 0 ; i < strs.length; i++){
            if(map.containsKey(sortedStr[i])){
                map.get(sortedStr[i]).add(strs[i]);
            } else{
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                map.put(sortedStr[i], l);
            }
        }
        
        for(Map.Entry<String, List<String>> e : map.entrySet()){
            finalResult.add(e.getValue());
        }
        
        return finalResult;
    }
}