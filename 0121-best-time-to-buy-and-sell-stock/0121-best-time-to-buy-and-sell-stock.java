class Solution {
    public int maxProfit(int[] prices) {
        
        int last_buy = prices[0];
        int max_profit = 0;
        for(int i=1; i< prices.length; i++){
            max_profit = Math.max(max_profit, prices[i] - last_buy);
            if(prices[i] < last_buy){
                last_buy = prices[i];
            }
        }
        return max_profit;
    }
}