class Solution {
    class DisjointSet{
        int[] rank, parent;
        public DisjointSet(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i = 0; i< n; i++){
                parent[i] = i;
                rank[i] = 0;
            }
        } 
        public int getParent(int u){
            if(parent[u] == u){
                return u;
            }
            return parent[u] = getParent(parent[u]);
        } 
        public void unionByRank(int u, int v){
            int uP_u = getParent(u);
            int uP_v = getParent(v);
            if(uP_u == uP_v){
                return;
            }
            if(rank[uP_u] > rank[uP_v]){
                parent[uP_v] = uP_u;
            }
            else if(rank[uP_u] < rank[uP_v]){
                parent[uP_u] = uP_v;
            }
            else{
                parent[uP_u] = uP_v;
                rank[uP_v] += 1;
            }
        } 

    }
    
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        //hashMap to store all parents of emails
        HashMap<String, Integer> parentMap = new HashMap<>();
        //Disjoint set to keep track of common parents
        DisjointSet ds = new DisjointSet(n);
        
        //For each Email add it to map and union the parents if there are any common
        for(int i = 0; i< accounts.size();i++){
            
            List<String> currentAccountEmails = accounts.get(i);
            
            for(int j = 1; j< accounts.get(i).size(); j++){
                
                String email = currentAccountEmails.get(j);   
                if(parentMap.containsKey(email)) ds.unionByRank(parentMap.get(email), i);
                else parentMap.put(email, i);
            }
        }
        
        //Create an array for each accounts index
        ArrayList<String> res[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            res[i] = new ArrayList<>();
        }
        // For each account add the emails as result of union find
        for(Map.Entry<String, Integer> e: parentMap.entrySet()){
            int uTP = ds.getParent(e.getValue());
            res[uTP].add(e.getKey());
        }

        List<List<String>> list = new ArrayList<>();
        
        //Sort the lists that are not empty and add to it to final result
        for(int i = 0; i < n; i++){
            if(res[i].size() == 0){
                continue;
            }
            Collections.sort(res[i]);
            res[i].add(0, accounts.get(i).get(0));
            list.add(res[i]);
        }
        return list;

    }
}