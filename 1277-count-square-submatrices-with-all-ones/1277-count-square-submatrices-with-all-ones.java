class Solution {
    public int countSquares(int[][] matrix) {
        int res = 0;
        
        for(int r = 0; r< matrix.length; r++){
            for(int c = 0; c < matrix[0].length; c++){
                if(matrix[r][c] > 0 && r > 0 && c > 0){
                    matrix[r][c] = Math.min(matrix[r-1][c], Math.min(matrix[r][c-1], matrix[r-1][c-1])) + 1;
                }
                 res += matrix[r][c];
                    
            }

        }
        
            //System.out.println("For size: "+ (i+1) + " Total Squares are: "+ totalSquares);
        
        return res;
    }
}