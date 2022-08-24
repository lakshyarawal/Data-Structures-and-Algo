class Solution {
    public int maxProfit(int[] prices) {

        int lowestBuy = prices[0];
        int maxProfit = 0;
        
        for(int i = 1; i < prices.length; i += 1){
            lowestBuy = Math.min(prices[i-1], lowestBuy);
            if(prices[i] - lowestBuy > maxProfit){
                maxProfit = prices[i] - lowestBuy;
            }
        }
        return maxProfit;
    }
}