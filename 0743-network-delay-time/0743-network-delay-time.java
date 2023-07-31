class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] time : times){
            adj.get(time[0]-1).add(new Pair(time[1], time[2]));
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k-1] = 0;
        while(!q.isEmpty()){
            int curNode = q.remove();
            int stepTime = minTime[curNode-1];

            for(Pair<Integer, Integer> nNode : adj.get(curNode-1)){
                if(stepTime+nNode.getValue() < minTime[nNode.getKey() - 1]){
                    minTime[nNode.getKey() - 1] = stepTime+nNode.getValue();
                    q.offer(nNode.getKey());
                }
            }
        }
        //System.out.println(Arrays.toString(minTime));
        int time = 0;
        for(int i = 0; i < n; i++){
            if(minTime[i] == Integer.MAX_VALUE)return -1;
            time = Math.max(time, minTime[i]);
        }
        return time;
    }
}