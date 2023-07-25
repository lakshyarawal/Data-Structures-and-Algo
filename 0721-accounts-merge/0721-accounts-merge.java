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
        HashMap<String, Integer> hashMap = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);
        for(int i = 0; i< accounts.size();i++){
            for(int j = 1; j< accounts.get(i).size(); j++){
                if(hashMap.containsKey(accounts.get(i).get(j))){
                    ds.unionByRank(hashMap.get(accounts.get(i).get(j)), i);
                }
                else{
                    hashMap.put(accounts.get(i).get(j), i);
                }
            }
        }

        ArrayList<String> res[] = new ArrayList[n];
        for(int i = 0; i< n; i++){
            res[i] = new ArrayList<>();
        }
        for(Map.Entry<String, Integer> e: hashMap.entrySet()){
            int uTP = ds.getParent(e.getValue());
            res[uTP].add(e.getKey());
        }

        List<List<String>> list = new ArrayList<>();
        
        for(int i = 0; i< n; i++){
            if(res[i].size() == 0){
                continue;
            }
            List<String> res2 = new ArrayList<>();
            Collections.sort(res[i]);
            res2.add(accounts.get(i).get(0));
            for(String E: res[i])
                res2.add(E);
            list.add(res2);
        }
        return list;

    }
}