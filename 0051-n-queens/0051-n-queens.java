
class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>(); // (r + c)
        Set<Integer> negDiag = new HashSet<>(); // (r - c)

        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];

        // Initialize the board with '.'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        // Backtracking function
        backtrack(0, n, col, posDiag, negDiag, board, res);
        return res;
    }

    private void backtrack(int r, int n, Set<Integer> col, Set<Integer> posDiag, Set<Integer> negDiag, char[][] board, List<List<String>> res) {
        if (r == n) {
            List<String> copy = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                copy.add(new String(board[i]));
            }
            res.add(copy);
            return;
        }

        for (int c = 0; c < n; c++) {
            if (col.contains(c) || posDiag.contains(r + c) || negDiag.contains(r - c)) {
                continue;
            }

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, n, col, posDiag, negDiag, board, res);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}