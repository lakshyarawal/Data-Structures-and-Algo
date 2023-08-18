class Solution {
    private int[][] dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
    private int res;
    
    public void dfs(int r, int c, int[][] grid, int t, int[][] time){
        for(int[] dir : dirs){
            int newr = r+dir[0];
            int newc = c+dir[1];
            if(newr >= grid.length || newr < 0 || newc >= grid[r].length || newc < 0) continue;
            if(grid[newr][newc] == 1 || (grid[newr][newc] == -1 && time[newr][newc] > t+1)){
                grid[newr][newc] = -1;
                time[newr][newc] = Math.min(time[newr][newc], t+1);
                dfs(newr, newc, grid, t+1, time);
            }
        }
    }
    
    public int orangesRotting(int[][] grid) {
        res = 0;
        int[][] time = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    time[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    time[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 2){
                    dfs(i, j, grid, 0, time);
                }
                 //System.out.println(Arrays.deepToString(time));
            }
        }
        
//         System.out.println(Arrays.deepToString(grid));
        System.out.println(Arrays.deepToString(time));
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    return -1;
                } else if(grid[i][j] == -1){
                    res = Math.max(res, time[i][j]);
                }
            }
        }
        
        return res;
    }
}