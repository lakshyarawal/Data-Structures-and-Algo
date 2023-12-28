class Solution:
    def findMissingAndRepeatedValues(self, grid: List[List[int]]) -> List[int]:
        res = [0, 0]
        seen_values = set()
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                if grid[i][j] in seen_values:
                    res[0] = grid[i][j]
                else:
                    seen_values.add(grid[i][j])
                    
        for i in range(1, max(seen_values) + 2):
            if i not in seen_values:
                res[1] = i
                break

        return res