class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int[] rows = new int[grid.length];
        int[] cols = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++){
            int row_sum = 0;
            for(int j = 0; j < grid[0].length; j++){
                row_sum += grid[i][j];
            }
            rows[i] = row_sum;
        }
        for(int j = 0; j < grid[0].length; j++){
            int col_sum = 0;
            for(int i = 0; i < grid.length; i++){
                col_sum += grid[i][j];
            }
            cols[j] = col_sum;
        }
        int[][] diff = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                diff[i][j] = rows[i] + cols[j] - (grid.length - rows[i]) - (grid[0].length - cols[j]);
            }
        }
        return diff;
    }
}