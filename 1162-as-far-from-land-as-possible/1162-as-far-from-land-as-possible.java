class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int maxDistance = n + n + 1;
        
        int[][] distance = new int[n][n];
        for (int[] arr : distance) Arrays.fill(arr, maxDistance);
        
        for(int i = 0; i <n; i++){
            for(int j = 0; j< n; j++){
                if(grid[i][j] == 1){
                    distance[i][j] = 0;
                } else{
                    distance[i][j] = Math.min(Math.min(i-1 >= 0 ? distance[i-1][j] +1 : maxDistance, j-1 >=0 ? distance[i][j-1] + 1: maxDistance), distance[i][j]);
                }
            }
        }
        int dist = Integer.MIN_VALUE;
        for(int i = n-1 ; i >= 0; i--){
            for(int j = n-1; j>=0; j--){
                if(grid[i][j] == 1){
                    distance[i][j] = 0;
                } else{
                    distance[i][j] = Math.min(Math.min(i < n-1 ? distance[i+1][j]+1 : maxDistance, j < n-1 ? distance[i][j+1]+1: maxDistance), distance[i][j]);
                    dist = Math.max(dist, distance[i][j]);
                }
            }
        }
        
        return dist == maxDistance || dist == Integer.MIN_VALUE ? -1: dist;
    }
}