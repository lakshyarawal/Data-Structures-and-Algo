class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int [n+1][m+1];
        for(int i=0;i<=n;i++)
            for(int j=0;j<=m;j++)
                dp[i][j]=0;
        int maxsize=0;
        for(int i=1;i<=n;i++)
            for(int j=1;j<=m;j++)
            {
                if(matrix[i-1][j-1]=='1')
                {
                    dp[i][j]=Math.min( dp[i-1][j], Math.min ( dp[i-1][j-1], dp[i][j-1] )) + 1 ;
                        maxsize=Math.max(maxsize,dp[i][j]);
                }
            }
        return maxsize*maxsize;
    }
}