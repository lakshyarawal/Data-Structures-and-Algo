class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int maxDistance = n + n + 1;
        
        for(int i = 0; i <n; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                } else{
                    grid[i][j] = maxDistance;
                    grid[i][j] = Math.min(Math.min(i-1 >= 0 ? grid[i-1][j] +1 : maxDistance, j-1 >=0 ? grid[i][j-1] + 1: maxDistance), grid[i][j]);
                }
            }
        }
        int dist = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0; i--){
            for(int j = n-1; j>=0; j--){
                    grid[i][j] = Math.min(Math.min(i < n-1 ? grid[i+1][j]+1 : maxDistance, j < n-1 ? grid[i][j+1]+1: maxDistance), grid[i][j]);
                    dist = Math.max(dist, grid[i][j]);
                
            }
        }
        
        return dist == maxDistance || dist == 0 ? -1: dist;
    }
}