class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i =0; i< points.length; i++){
            int d = (points[i][0]*points[i][0]) + (points[i][1]*points[i][1]);
            pq.add(d);
            if(hm.containsKey(d)){
                List<Integer> One = hm.get(d);
                One.add(i);
                hm.put(d, One);
            }
            else{
                List<Integer> One = new ArrayList<Integer>();
                One.add(i);
                hm.put(d, One);
            }
            
        }
        int[][] results = new int[k][2];
        int idx = 0;
        while(k > 0){
            int el = pq.poll();
            //System.out.println(el);
            List<Integer> curr = hm.get(el);
            int id = curr.remove(0);
            results[idx] = points[id];
            idx++;
            k--;
        }
        return results;
    }
}