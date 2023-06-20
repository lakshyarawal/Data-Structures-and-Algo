class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        int[] indegree = new int[numCourses];
        ArrayList<ArrayList<Integer>> a = new ArrayList<>(numCourses);
        
        for(int i = 0; i < numCourses; i++){
            a.add(new ArrayList<>()); 
        }
        
        for(int[] preq : prerequisites){
            a.get(preq[1]).add(preq[0]);
            indegree[preq[0]]++;
        }
        
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i< numCourses; i++){
            if(indegree[i] == 0){
                deque.addFirst(i);
            }
        }
                             
        int nodesVisited = 0;
                                 
        while(!deque.isEmpty()){
            int node = deque.poll();
            nodesVisited++;
            
            for(int neighbour: a.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    deque.offer(neighbour);
                }
            }
        }
        
        return nodesVisited == numCourses;
    }
}