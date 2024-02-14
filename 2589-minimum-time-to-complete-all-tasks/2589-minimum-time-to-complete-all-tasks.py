class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        line = [False] * 2001
        tasks.sort(key=lambda x: x[1])
        for s, e, d in tasks:
            for t in range(s, e + 1):
                d -= line[t]
            t = e
            while d > 0:
                if not line[t]:
                    line[t] = True
                    d -= 1
                t -= 1
        return sum(line)
        