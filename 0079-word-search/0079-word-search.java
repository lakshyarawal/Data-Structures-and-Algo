class Solution {
    private boolean res;
    
    public void dfs(char[][] board, String word, int pos, int x, int y){
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0) return;
        if(pos >= word.length()) return;
        if(word.charAt(pos) != board[x][y]) return;
        if(word.charAt(pos) == board[x][y]){
            //System.out.println("Character: "+word.charAt(pos) + " PositionX: "+ x + " PositionY: "+ y + "POS: " + pos);
            if(pos == word.length()-1){
                res = true;
                return;
            }
            board[x][y] = '#';
            dfs(board, word, pos+1, x+1, y);
            dfs(board, word, pos+1, x, y+1);
            dfs(board, word, pos+1, x-1, y);
            dfs(board, word, pos+1, x, y-1);
            board[x][y] = word.charAt(pos);
        }
    }
    
    public boolean exist(char[][] board, String word) {
        res = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j< board[0].length; j++){
                dfs(board, word, 0, i, j);
            }
        }
        return res;
    }
}