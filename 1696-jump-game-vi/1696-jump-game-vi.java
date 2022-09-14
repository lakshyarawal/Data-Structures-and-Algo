class Solution {
    public int maxResult(int[] nums, int k) {
        int[] score = new int[nums.length];
        score[0] = nums[0];
        Deque<Integer> dq = new ArrayDeque<Integer>();
        dq.offer(0);
        for(int i=1; i< nums.length; i++){
            while(dq.peekFirst() != null && dq.peekFirst() < i-k){
                dq.pollFirst();
            }
            score[i] = nums[i] + score[dq.peekFirst()];
            while (dq.peekLast() != null && score[i] >= score[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        return score[nums.length-1];
    }
}