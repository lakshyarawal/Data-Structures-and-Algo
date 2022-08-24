class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] lowestBuy = new int[n];
        lowestBuy[0] = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n; i += 1){
            lowestBuy[i] = Math.min(prices[i-1], lowestBuy[i-1]);
            if(prices[i] - lowestBuy[i] > maxProfit){
                maxProfit = prices[i] - lowestBuy[i];
            }
        }
        return maxProfit;
    }
}