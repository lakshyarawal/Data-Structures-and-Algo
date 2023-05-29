class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;;
        int count = 0;
        for (int row=0; row < n;row++) {
            for (int col=0;col<m;col++) {
                if (grid[row][col] == 0 && !dfs(row, col, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
    
// return true if cell touches the wall, or connected to another cell touching the wall
    boolean dfs(int row, int col, int[][] grid) { 
        if (grid[row][col] == 0) {
            grid[row][col] = 2; // mark as visited
        
            boolean up = row == 0 || dfs(row-1, col, grid);
            boolean down = row == grid.length-1 || dfs(row+1, col, grid);
            boolean left = col ==0 || dfs(row, col - 1, grid);
            boolean right = col == grid[0].length-1 || dfs(row, col + 1, grid);

            return up || down || left || right;
        }
        return false;
    }
}