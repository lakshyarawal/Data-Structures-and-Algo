class Solution {
    int rows, cols;
    public boolean checkSquare(int r, int c, int size, int[][] matrix){
        if(r + size >= rows) return false;
        if(c + size >= cols) return false;
        for(int i = r; i <= r + size; i++){
            for(int j = c; j <= c+ size; j++){
                if(matrix[i][j] != 1) return false;
            }
        }
        return true;
    }
    
    public int countSquares(int[][] matrix) {
        int totalSquares = 0;
        rows = matrix.length;
        cols = matrix[0].length;
        int maxSize = Math.min(rows, cols);
        for(int i = 0;i < maxSize; i++){
            for(int j = 0; j< rows; j++){
                for(int k = 0; k < cols; k++){
                    if(checkSquare(j, k, i, matrix)){
                        totalSquares++;
                    }
                }
            }
            //System.out.println("For size: "+ (i+1) + " Total Squares are: "+ totalSquares);
        }
        return totalSquares;
    }
}