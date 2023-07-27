class Solution {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        int res = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(matrix[r][c] == '1' && r > 0 && c > 0 && matrix[r-1][c] == '1' && matrix[r][c-1] == '1'){
                    dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1])) + 1;
                } else if(matrix[r][c] == '1'){
                    dp[r][c] = 1;
                }
                res = Math.max(res, dp[r][c]);
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        return res*res;
    }
}