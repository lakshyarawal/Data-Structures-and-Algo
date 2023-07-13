class Solution {
    
    public int countNeighbors(int r, int c, int[][] board){
        int neighbors = 0;
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
        for(int[] dir : directions){
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            if(newRow < board.length && newRow >= 0 && newCol < board[0].length && newCol >= 0){
                if(board[newRow][newCol] == 1 || board[newRow][newCol] == -1)neighbors++;
            }
        }
        return neighbors;
    }
    
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                int neighbors = countNeighbors(i, j, board);
                //Condn 1
                if(board[i][j] == 1 && (neighbors < 2 || neighbors > 3)){
                    board[i][j] = -1;
                } else if(board[i][j] == 0 && neighbors == 3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i< m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == -1) board[i][j] = 0;
                else if(board[i][j] == 2) board[i][j] = 1;
            }
        }
        
    }
}