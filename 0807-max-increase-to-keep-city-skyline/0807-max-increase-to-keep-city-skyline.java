class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int increse_val = 0;
        int[] row_max = new int[grid.length];
        int[] col_max = new int[grid.length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid.length; j++){
                row_max[i] = Math.max(row_max[i], grid[i][j]);
                col_max[j] = Math.max(col_max[j], grid[i][j]);
            }
        }
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j< grid.length; j++){
                
                increse_val += Math.max(0, Math.min(row_max[i], col_max[j])-grid[i][j]);
            }
        }
        //System.out.println(Arrays.toString(row_max));
        //System.out.println(Arrays.toString(col_max));
        return increse_val;
    }
}