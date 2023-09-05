class Pair {
    int node;
    int distance;
    Pair(int i, int j) {
        node=i;
        distance=j;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<List<Pair>> adj=new ArrayList<>();
        int n=points.length;
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];
                
                int dist=getDist(x1, y1, x2, y2);
                
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));
            }
        }
        int[] vis=new int[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>((x, y) -> x.distance-y.distance);
        pq.add(new Pair(0, 0));
        int sum=0;
        
        while(!pq.isEmpty()) {
            Pair pair=pq.poll();
            int node=pair.node;
            int dis=pair.distance;

            if(vis[node]==1) continue;
            vis[node]=1;

            sum+=dis;
            for(Pair it: adj.get(node)) {
                if(vis[it.node]==0) {
                    pq.add(it);
                }
            }
        }
        return sum;
    }
    int getDist(int a, int b, int c, int d) {
        return Math.abs(Math.abs(a-c) + Math.abs(b-d));
    }
}