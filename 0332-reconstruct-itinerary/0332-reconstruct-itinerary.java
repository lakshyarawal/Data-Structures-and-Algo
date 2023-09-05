class Solution {
    List<String> rl;
    boolean found;
    
    
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, LinkedList<String>> map = new HashMap<>();
        HashMap<String, boolean[]> vedMap = new HashMap<String, boolean[]>();
        
        for(List<String> ticket:tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);
            LinkedList<String> ls = map.getOrDefault(from, new LinkedList<String>());
            ls.add(to);
            map.put(from, ls);
        }
        
        for(String key:map.keySet()){
            int size = map.get(key).size();
            vedMap.put(key, new boolean[size]);
            Collections.sort(map.get(key), (a,b)->{
                return a.compareTo(b);
            });
        }
        
        // System.out.println(map);
        // System.out.println(vedMap);
                
        found=false;
        rl = new ArrayList<String>();
        List<String> ol = new ArrayList<String>(Arrays.asList("JFK"));
        
        backTrack(map, vedMap, ol, "JFK", tickets.size()+1);
        
        return rl;
        
    }
    
    private void backTrack(HashMap<String, LinkedList<String>> map, HashMap<String, boolean[]> vedMap, List<String> result, String cur, int n){
        if(found) return;
        if(result.size()==n){
            rl= new ArrayList<>(result);
            found=true;
            return;
        }
        
        List<String> nextLs = map.get(cur);
        if(nextLs==null){
            return;
        }
        boolean[] ved = vedMap.get(cur);
        for(int i=0;i<nextLs.size();i++){
            if(ved[i]==true) continue;
            String to = nextLs.get(i);
            result.add(to);
            // System.out.println(result);
            vedMap.get(cur)[i]=true;
            
            backTrack(map, vedMap, result, to, n);
            
            result.remove(result.size()-1);
            vedMap.get(cur)[i]=false;
            
        }
    
    }
}