class Solution {
    private void markLand(int[][] grid, int i, int j){
        grid[i][j] = 1;
        
        if(i>0 && grid[i-1][j] == 0)
            markLand(grid, i-1, j);
        
        if(j>0 && grid[i][j-1] == 0)
            markLand(grid, i, j-1);
        
        if(i<grid.length-1 && grid[i+1][j] == 0)
            markLand(grid, i+1, j);
        
        if(j<grid[0].length-1 && grid[i][j+1] == 0)
            markLand(grid, i, j+1);
    }
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i=0; i<m; i++){
            if(grid[i][0] == 0)
                markLand(grid, i, 0);
            
            if(grid[i][n-1] == 0)
                markLand(grid, i, n-1);
        }
        
        for(int i=0; i<n; i++){
            if(grid[0][i] == 0)
                markLand(grid, 0, i);
            
            if(grid[m-1][i] == 0)
                markLand(grid, m-1, i);
        }
        
        
        int closedIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    closedIslands++;
                    markLand(grid, i, j);
                }
            }
        }
        
        return closedIslands;
    }
}