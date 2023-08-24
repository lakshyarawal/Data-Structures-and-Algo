class Solution {
    public int calculateTime(int speed, int[] piles){
        int t = 0;
        for(int num : piles){
            t += Math.ceil((double)(num) /(double)(speed));
        }
        return t;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int p : piles){
            maxPile = Math.max(maxPile, p);
        }
        int start = 1;
        int end = maxPile;
        while(start <= end){
            int mid = start + ((end - start) >> 1);
            int t = calculateTime(mid, piles);
            if(t <= h){
                end = mid - 1;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
}
