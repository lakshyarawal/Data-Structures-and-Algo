class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        if(n == 0) return res;
        HashMap<Character, int[]> indexMap = new HashMap<>();
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            if(indexMap.containsKey(c)){
                indexMap.put(c, new int[]{indexMap.get(c)[0], i});
            } else{
                indexMap.put(c, new int[]{i, i});
            }
        }
        int end = 0;
        int prev = -1;
        for(int i = 0; i < n; i++){
            char c = s.charAt(i);
            end = Math.max(end, indexMap.get(c)[1]);
            if(end == i){
                res.add(i - prev);
                prev = i;
            }
        }
        return res;
        
    }
}