class Solution:
    def __init__(self):
        self.dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]]
    def dfs(self, r, c, grid, t, time):
        for dir in self.dirs:
            newr, newc = r + dir[0], c + dir[1]
            if (
                newr >= len(grid)
                or newr < 0
                or newc >= len(grid[r])
                or newc < 0
            ):
                continue
            if (
                grid[newr][newc] == 1
                or (grid[newr][newc] == -1 and time[newr][newc] > t + 1)
            ):
                grid[newr][newc] = -1
                time[newr][newc] = min(time[newr][newc], t + 1)
                self.dfs(newr, newc, grid, t + 1, time)
                
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n, res = len(grid), len(grid[0]), 0
        if m == 0 or n == 0:
            return 0

        time = [[0] * n for _ in range(m)]

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    time[i][j] = 0
                if grid[i][j] == 1:
                    time[i][j] = float('inf')

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 2:
                    self.dfs(i, j, grid, 0, time)

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    return -1
                elif grid[i][j] == -1:
                    res = max(res, time[i][j])

        return res
        