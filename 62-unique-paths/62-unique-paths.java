class Solution {
    
    public int uniquePaths(int m, int n) {
        if(m == 1 || n ==1){
            return 1;
        }
        int[][] totalPaths = new int[m][n];
           for(int[] arr : totalPaths) {
               Arrays.fill(arr, 1);
            }
        for(int i = 1; i < m; i ++){
            for(int j = 1; j < n; j++){
                totalPaths[i][j] = totalPaths[i-1][j] + totalPaths[i][j-1];
            }
        }
        return totalPaths[m-1][n-1];
    }
    
}