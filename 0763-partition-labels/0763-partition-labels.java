class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        if(n == 0) return res;
        HashMap<Character, int[]> indexMap = new HashMap<>();
        char[] ch = s.toCharArray();
        for(int i = 0; i < n; i++){
            if(indexMap.containsKey(ch[i])){
                indexMap.put(ch[i], new int[]{indexMap.get(ch[i])[0], i});
            } else{
                indexMap.put(ch[i], new int[]{i, i});
            }
        }
        int end = 0;
        int prev = -1;
        for(int i = 0; i < n; i++){
            end = Math.max(end, indexMap.get(ch[i])[1]);
            if(end == i){
                res.add(i - prev);
                prev = i;
            }
        }
        return res;
        
    }
}