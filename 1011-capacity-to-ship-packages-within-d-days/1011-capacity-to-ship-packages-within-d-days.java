class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0, hi = 0;
        
        for(int w : weights){
            lo = Math.max(lo, w);
            hi += w;
        }
        
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(check(weights, days, mid)){
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public boolean check(int[] weights, int days, int mid){
        int sum = 0;
        int count = 0;
        for(int w: weights){
            sum += w;
            if(sum > mid){
                count++;
                sum = w;
                if(count == days){
                    return false;
                }
            }
        }
        return true;
    }
}