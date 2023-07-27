class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, List<Integer>> neighbors = new HashMap<>();
        Set<Integer> addedElements = new HashSet<>();
        
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue()-b.getValue());
        
        
        for(int i = 0; i < adjacentPairs.length; i++){
            if(countMap.containsKey(adjacentPairs[i][0])){
                countMap.put(adjacentPairs[i][0],  2);
                List<Integer> l = neighbors.get(adjacentPairs[i][0]);
                l.add(adjacentPairs[i][1]);
                neighbors.put(adjacentPairs[i][0], l); 
            }else {
                countMap.put(adjacentPairs[i][0], 1);
                List<Integer> l = new ArrayList<>();
                l.add(adjacentPairs[i][1]);
                neighbors.put(adjacentPairs[i][0], l); 
            }
            if(countMap.containsKey(adjacentPairs[i][1])){
                countMap.put(adjacentPairs[i][1],  2);
                List<Integer> l = neighbors.get(adjacentPairs[i][1]);
                l.add(adjacentPairs[i][0]);
                neighbors.put(adjacentPairs[i][1], l); 
            }else {
                countMap.put(adjacentPairs[i][1], 1);
                List<Integer> l = new ArrayList<>();
                l.add(adjacentPairs[i][0]);
                neighbors.put(adjacentPairs[i][1], l); 
            }
        }
        
        for(Map.Entry<Integer, Integer> e : countMap.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        
        int i = 0;
        int[] res = new int[adjacentPairs.length+1];
        int prev = pq.remove().getKey();
        addedElements.add(prev);
        while(i < adjacentPairs.length+1){
            res[i] = prev;
            //System.out.println("res: "+ Arrays.toString(res));
            List<Integer> newPrev = neighbors.get(prev);
            //System.out.println("new Prev: "+ newPrev);
            for(int el : newPrev){
                //System.out.println("Elements: "+ el);
                if(!addedElements.contains(el)){
                    addedElements.add(el);
                    prev = el;
                    break;
                }
            }
            i++;
        }
        return res;
    }
}