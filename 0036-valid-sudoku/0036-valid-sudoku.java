class Solution {
    
    public boolean isValidRow(char[] row){
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < row.length; i++){
            if(row[i] == '.') continue;
            if(s.contains(row[i])) return false;
            s.add(row[i]);
        }
        return true;
    }

    public boolean isValidSquare(int r, int c, char[][] board){
        Set<Character> s = new HashSet<>();
        for(int i = r; i < r+3; i++){
            for(int j = c; j < c+3; j++){
                if(board[i][j] == '.') continue;
                if(s.contains(board[i][j])) return false;
                s.add(board[i][j]);
            }
        }
        return true;
    }
    
    public boolean isValidSudoku(char[][] board) {
        
        for(char[] row : board){
            if(!isValidRow(row)) return false;
        }
        
        char[][] cols = new char[board[0].length][board.length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0 ; j < board[i].length; j++){
                cols[j][i] = board[i][j];
            }
        }
        for(char[] col : cols){
            if(!isValidRow(col)) return false;
        }
        
        for(int i = 0; i < board.length; i+=3){
            for(int j = 0 ; j < board[i].length; j+=3){
                if(!isValidSquare(i, j, board)) return false;
            }
        }
        
        return true;
        
    }
}