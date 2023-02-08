class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        dfs(image, sr, sc, color, image[sr][sc]);
        return image;
    }
    public void dfs(int[][] mat, int r, int c, int color, int og){
        if(mat[r][c] == color || mat[r][c] != og) return;
        mat[r][c] = color;
        if(r+1 < mat.length) dfs(mat, r+1, c, color, og);
        if(c+1 < mat[0].length) dfs(mat, r, c+1, color, og);
        if(r-1 >-1) dfs(mat, r-1, c, color, og);
        if(c-1 >-1) dfs(mat, r, c-1, color, og);
        return;
    }
}