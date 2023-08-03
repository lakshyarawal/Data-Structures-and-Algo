class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>(n+1);
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int[] time : times){
            adj.get(time[0]).add(new Pair(time[1], time[2]));
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(k);
        int[] minTime = new int[n+1];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k] = 0;
        while(!q.isEmpty()){
            int curNode = q.remove();
            int stepTime = minTime[curNode];

            for(Pair<Integer, Integer> nNode : adj.get(curNode)){
                if(stepTime+nNode.getValue() < minTime[nNode.getKey()]){
                    minTime[nNode.getKey()] = stepTime+nNode.getValue();
                    q.offer(nNode.getKey());
                }
            }
        }

        int time = 0;
        for(int i = 1; i <= n; i++){
            if(minTime[i] == Integer.MAX_VALUE)return -1;
            time = Math.max(time, minTime[i]);
        }
        return time;
    }
}