class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }  
        for(int[] edge: edges){
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
            adj.get(edge[1]).add(new Pair(edge[0], edge[2]));
        } 
        int res = -1;
        int minCitiesVisited = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int citiesVisited = 0;
            List<Pair<Integer, Integer>> immediateNeighbors = adj.get(i);
            Queue<Pair<Integer, Integer>> q = new LinkedList<>(); 
            for(Pair<Integer, Integer> p : immediateNeighbors){
                q.offer(p);
            }
            int[] visited = new int[n];
            boolean[] visBoolean = new boolean[n];
            Arrays.fill(visited, Integer.MAX_VALUE);
            visited[i] = Integer.MIN_VALUE;
            while(!q.isEmpty()){
                int size = q.size();
                while(size>0){
                    Pair<Integer, Integer> p = q.poll();
                    int node =p.getKey();
                    int weight = p.getValue();
                    if(weight < visited[node] && weight <= distanceThreshold){
                        visited[node] = weight;
                        
                        if(!visBoolean[node]){
                            visBoolean[node] = true;
                            citiesVisited++;
                        }
                        
                        if(weight < distanceThreshold){
                            List<Pair<Integer, Integer>> newNeigbors = adj.get(node);
                            for(Pair<Integer, Integer> pi : newNeigbors){
                                if(visited[pi.getKey()] > pi.getValue()+weight){
                                    if(pi.getValue()+weight <= distanceThreshold){
                                        q.offer(new Pair(pi.getKey(), pi.getValue()+weight));
                                    }
                                }
                                
                            }
                        }
                    }
                    size--;
                }
            }
            if(citiesVisited <= minCitiesVisited){
                minCitiesVisited = citiesVisited;
                res = i;
            }
        }
        return res;
    }
}