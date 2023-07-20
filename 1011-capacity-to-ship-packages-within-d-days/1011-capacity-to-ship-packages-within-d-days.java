class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for(int i=0; i<weights.length; i++){
            lo = Math.max(lo, weights[i]);
            hi = hi + weights[i];
        }
        int ans = hi;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(check(weights, days, mid)){
                ans = mid;
                hi = mid -1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    
    public boolean check(int[] weights, int days, int mid){
        int sum = 0;
        int count = 0;
        for(int i=0; i<weights.length; i++){
            sum = sum + weights[i];
            if(sum > mid){
                count++;
                sum = weights[i];
                if(count == days){
                    return false;
                }
            }
        }
        return true;
    }
}