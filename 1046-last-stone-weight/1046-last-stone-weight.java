class Solution {
    public int lastStoneWeight(int[] stones) {
        if(stones.length == 1) return stones[0];        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.add(stone);
        }
        
        while(pq.size() > 1){
            int a = pq.remove();
            int b = pq.remove();
            System.out.println("A: " + a + " B: "+ b);
            if(a == b) continue;
            if(a > b) pq.add(a-b);
        }
        if(pq.size() == 0) return 0;
        return pq.peek();
    }
}