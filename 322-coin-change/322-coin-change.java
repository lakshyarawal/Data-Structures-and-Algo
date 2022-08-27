public class Solution {
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp, amount+1);
    dp[0] = 0;
    
	for(int a = 1; a < amount+ 1; a += 1){
        for(int c : coins){
            if(a-c >= 0){
               dp[a] = Math.min(1 + dp[a-c], dp[a]); 
            }
            
        }
    }
    if(dp[amount] == amount+1){
        return -1;
    }
	return dp[amount];
}
}