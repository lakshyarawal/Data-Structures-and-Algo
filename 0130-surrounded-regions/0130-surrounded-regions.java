class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int i;
        Queue<int[]> queue = new LinkedList<>();
        for(i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(board[i][j] == 'O'){
                        queue.add(new int[]{i, j});
                        board[i][j] = 'V';
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            int[] currPoint = queue.poll();
            int x = currPoint[0];
            int y = currPoint[1];

            if(x-1 >= 0 && board[x-1][y] == 'O'){
                queue.add(new int[]{x-1, y});
                board[x-1][y] = 'V';
            }
            if(x+1 < n && board[x+1][y] == 'O'){
                queue.add(new int[]{x+1, y});
                board[x+1][y] = 'V';
            }
            if(y-1 >= 0 && board[x][y-1] == 'O'){
                queue.add(new int[]{x, y-1});
                board[x][y-1] = 'V';
            }
            if(y+1 < m && board[x][y+1] == 'O'){
                queue.add(new int[]{x, y+1});
                board[x][y+1] = 'V';
            }
        }

        for(i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i][j] == 'V'){
                    board[i][j] = 'O';
                }
                else{
                    board[i][j] = 'X';
                }
            }
        }
    }
}