class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, int[]> indexMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(indexMap.containsKey(curr)){
                int[] newIdx = indexMap.get(curr);
                newIdx[1] = i;
                indexMap.put(curr, newIdx);
            } else{
                int[] newIdx = new int[2];
                newIdx[0] = i;
                newIdx[1] = i;
                indexMap.put(curr, newIdx);
            }
        }
        // for(Map.Entry<Character, int[]> e : indexMap.entrySet()){
        //     System.out.println(e.getKey() + " " + Arrays.toString(e.getValue()));
        // }
        
        List<Integer> l = new ArrayList<>();
        int farthest = 0;
        int i = 0; 
        while(i < s.length()){
            int[] curr = indexMap.get(s.charAt(i));
            farthest = curr[1];
            int newFarthest = farthest;
            for(int j = i+1; j < s.length(); j++){
                if(j >= newFarthest) break;
                newFarthest = Math.max(newFarthest, indexMap.get(s.charAt(j))[1]);
            }
            if(l.size() > 0){
                l.add(newFarthest+1 - i);
            }else{
                 l.add(newFarthest+1);
            }
            i = newFarthest+1;
               
            
        }
        return l;

    }
}