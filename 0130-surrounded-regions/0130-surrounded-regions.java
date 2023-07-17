class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 ) return;
        int m = board.length;
        int n = board[0].length;
        markBorders(board);
        
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }
    
    public void markBorders(char[][] board){
        int m = board.length;
        int n = board[0].length;
        
        for(int j = 0; j<n; j++){
            if(board[0][j] == 'O'){
                markOtoY(board, 0, j);
            }
            if(board[m-1][j] == 'O'){
                markOtoY(board, m-1, j);
            }
        }
        
        for(int i = 0; i<m; i++){
            if(board[i][0] == 'O'){
                markOtoY(board, i, 0);
            }
            if(board[i][n-1] == 'O'){
                markOtoY(board, i, n-1);
            }
        }
    }
    
    public void markOtoY(char[][] board, int i, int j){
        
        if(i<0 || i>= board.length || j < 0 || j >= board[0].length || board[i][j]!='O') return;
        
        board[i][j] = 'Y';
        markOtoY(board, i+1, j);
        markOtoY(board, i-1, j);
        markOtoY(board, i, j+1);
        markOtoY(board, i, j-1);
    }
}