class Solution {

    public pair helper(int[] arr, int start, int end, pair dp[][]){
        if(start > end){
            return new pair(0, 100000);
        }
        if(start == end){
            return new pair(arr[start], 0);
        }
        if(dp[start][end] != null){
            return dp[start][end];
        }
        pair ans = new pair(0, 1000000);
        for(int i = start; i<end; i++){
            pair pairLeft = helper(arr, start, i, dp);
            pair pairRight = helper(arr, i+1, end, dp);
            int total = pairLeft.totalSum + pairRight.totalSum + (pairLeft.maxVal*pairRight.maxVal);
            if(total < ans.totalSum){
                ans.totalSum = total;
                ans.maxVal = Math.max(pairLeft.maxVal, pairRight.maxVal);
            }
        }
        dp[start][end] = ans;
        return ans;
    }

    public int mctFromLeafValues(int[] arr) {
        int l = arr.length;
        if(l == 2){
            return arr[0] * arr[1];
        }
        return helper(arr, 0, l-1, new pair[l][l]).totalSum;   
    }

    class pair{
        int totalSum;
        int maxVal;
        pair(int maxVal, int totalSum){
            this.totalSum =  totalSum;
            this.maxVal = maxVal;
        }
    }
}