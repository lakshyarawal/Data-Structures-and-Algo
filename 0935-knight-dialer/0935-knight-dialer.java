class Solution {
    static int[][] lst = { {4,6}, {6,8}, {7,9}, {4,8}, {0,1,3}, {}, {0,1,7}, {2,6}, {1,3}, {2,4} };
    static int[][] dp;
    static boolean alreadyDone = false;
    private static void calculate() {
        dp = new int[50001][11];
        Arrays.fill(dp[1], 1);
        dp[1][10] = 10;
        int MOD = 1000000007;
        for(int i = 2; i <= 5000; i++) {
            int res = 0;
            for(int j = 0; j < 10; j++) {
                if(j == 5) {
                    continue;
                }
                for(int x : lst[j]) {
                    dp[i][j] = (((dp[i][j]%MOD) + (dp[i-1][x]%MOD)) % MOD);
                }
                res = (((res%MOD) + (dp[i][j]%MOD)) % MOD); 
            }
            dp[i][10] = res;
        }
    }
    Solution() {
        if(!alreadyDone) {
            alreadyDone = true;
            calculate();
        }
    }
    public int knightDialer(int n) {
        return dp[n][10];
    }
}