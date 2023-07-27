class Solution {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]=='1'){
                    matrix[i][j] = (char)(1 + min(
                        i>0 ? (int)matrix[i-1][j] : 0,
                        j>0 ? (int)matrix[i][j-1] : 0,
                        i>0 && j>0 ? (int)matrix[i-1][j-1] : 0
                    ));
                    
                    res = Math.max(res, (int)matrix[i][j]);
                } else {
                    matrix[i][j] = (char)0;
                }
            }
        }
        return res * res;
    }
    
    int min(int i, int j, int k){
        return Math.min(i, Math.min(j, k));
    }
}