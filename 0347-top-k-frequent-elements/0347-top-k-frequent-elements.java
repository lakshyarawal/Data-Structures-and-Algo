class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> valueCount = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            valueCount.put(nums[i], valueCount.getOrDefault(nums[i], 0)+1);
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<Integer, Integer> e : valueCount.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll().getKey();
            i++;
        }
        return res;
    }
}