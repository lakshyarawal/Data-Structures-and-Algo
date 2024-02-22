class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        indegree = [0 for _ in range(n+1)]
        outdegree = [0 for _ in range(n+1)]
        
        for i in range(len(trust)):
            indegree[trust[i][0]] += 1
            outdegree[trust[i][1]] += 1
            
        #print(indegree)
        #print(outdegree)
        for i in range(1, n+1):
            if indegree[i] == 0 and outdegree[i] == n-1:
                return i
        return -1