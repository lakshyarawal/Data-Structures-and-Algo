class Solution {
    int[] gNums;
    public int indexOfEl(int el){
        for(int i = 0; i < gNums.length; i++){
            if(gNums[i] == el){
                return i;
            }
        }
        return -1;
    }
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int n = nums.length;
        gNums = nums;
        int[] minTill = new int[n];
        int[] maxTill = new int[n];
        minTill[0] = nums[0];
        maxTill[0] = nums[0];
        for(int i = 1; i < n; i++){
            minTill[i] = Math.min(minTill[i-1], nums[i]);
            maxTill[i] = Math.max(maxTill[i-1], nums[i]);
        }
        
        int[] ans = new int[]{-1, -1};
        
        for(int i = n-1; i >= indexDifference; i--){
            if(Math.abs(minTill[i-indexDifference] - nums[i]) >= valueDifference){
                ans[0] = i;
                ans[1] = indexOfEl(minTill[i-indexDifference]);
                return ans;
            }
            else if(Math.abs(maxTill[i-indexDifference] - nums[i]) >= valueDifference){
                ans[0] = i;
                ans[1] = indexOfEl(maxTill[i-indexDifference]);
                return ans;
            }
        }
        return ans;
    }
}