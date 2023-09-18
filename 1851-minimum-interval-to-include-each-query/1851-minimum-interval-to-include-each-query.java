class Solution {
   
     public int[] minInterval(int[][] intervals, int[] queries) {
        
         Arrays.sort(intervals, Comparator.comparingInt(a-> ((int[])a)[0]));
         int[] copyQueries = queries.clone();
         Arrays.sort(copyQueries);
         
         PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> ((int[])a)[0]));
         Map<Integer, Integer> resMap = new HashMap<>();
         
         int N = intervals.length;
         int i=0;
         for(int k = 0; k < copyQueries.length; k++){
             int q = copyQueries[k];
             if(k>0 && q==copyQueries[k-1])
                 continue;
             
             //add eligible intervals based on start time(i.e start <= q)
             while(i < N && intervals[i][0] <= q){
                 pq.offer(new int[]{intervals[i][1] - intervals[i][0] + 1,
                                    intervals[i][1]});
                 i++;
             }
             
             //remove ineligible intervals based on end time(i.e end < q)
             while(!pq.isEmpty() && pq.peek()[1] < q)
                 pq.poll();
             
             resMap.put(q, pq.isEmpty() ? -1 : pq.peek()[0]);
         }
         
         int[] res = new int[queries.length];
         int ind=0;
         for(int q : queries){
             res[ind++] = resMap.get(q);
         }
         
         return res;
     }
   
}