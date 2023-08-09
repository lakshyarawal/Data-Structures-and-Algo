class Solution {
    
    private int[] visited;
    private int[][] graph;
    
    public boolean bfs(int node){
        visited[node] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()) {
            int current = q.poll();
            for (int c: graph[current]) {
                if (visited[c] == 0) {
                    visited[c] = (visited[current] == 1) ? 2 : 1;
                    q.offer(c);
                } else {
                    if (visited[c] == visited[current]) return false;
                }
            }
        }
        return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        visited = new int[graph.length];
        this.graph = graph;
        
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length != 0 && visited[i] == 0) {  
                if(!bfs(i)) return false;
            }
        }
        return true;
    }
}