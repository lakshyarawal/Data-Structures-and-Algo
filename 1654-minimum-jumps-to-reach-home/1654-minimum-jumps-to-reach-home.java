class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        for(int forbid : forbidden){
            visited.add(forbid);
        }
        Set<Integer> stepsTaken = new HashSet<>();
        q.offer(new int[]{0,0,1});//node,steps,forward
        
        while(!q.isEmpty()){
            int[] val = q.poll();
            int node = val[0];
            int steps = val[1];
            int isForward = val[2];
            if(node==x){
                return steps;
            }
            if(visited.contains(node)){
                continue;
            }
            if(isForward==1){
                //can visit forward and backward both
                int backStep = node-b;
                if(backStep>=0 && stepsTaken.add(backStep)){
                 q.offer(new int[]{backStep,steps+1,-1});
                }
            }
            int forwardStep = node+a;
            if(forwardStep>=0 && forwardStep<(2000+2*b) && stepsTaken.add(forwardStep)){
                q.offer(new int[]{forwardStep,steps+1,1});
            }
        }
        return -1;
    }
}