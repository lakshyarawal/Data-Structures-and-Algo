class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        int[] order = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numCourses);
        
        for(int i =0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] preq: prerequisites){
            adj.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                deque.offer(i);
            }
        }
        
        int nodesVisited = 0;
        int j = 0;
        while(!deque.isEmpty()){
            
            int node = deque.poll();
            nodesVisited++;
            order[j] = node;
            j++;
            
            for(int neighbour: adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    deque.offer(neighbour);
                }
            }

            
            indegree[node]--;
            
        }
        int[] empty = {};
        return nodesVisited == numCourses ? order : empty;
    }
}