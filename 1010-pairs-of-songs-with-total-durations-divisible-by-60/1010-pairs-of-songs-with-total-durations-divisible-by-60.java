class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int[] map = new int[60];
        int cntr = 0;
        for (int t : time) {
            cntr += map[(60 - t % 60) % 60];
            map[t % 60] += 1;
        }
        return cntr;
    }
}