class Solution {
    
    private List<List<Integer>> paths;
    
    public void explorePaths(int source, int target, List<Integer> curPath, int[][] graph){
        for(int i = 0; i< graph[source].length; i++){
            List<Integer> n = new ArrayList<>(curPath); 
            n.add(graph[source][i]);
            if(graph[source][i] == target){
                paths.add(n);
            }
            else{
               explorePaths(graph[source][i], target, n, graph);
            }
        }
    }
        
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        paths = new ArrayList<>();
        List<Integer> c = new ArrayList<>();
        c.add(0);
        explorePaths(0, graph.length-1, c, graph);
        return paths;
    }
}