class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        indegree = [0] * numCourses
        order = [0] * numCourses
        adj = [[] for _ in range(numCourses)]

        for preq in prerequisites:
            adj[preq[1]].append(preq[0])
            indegree[preq[0]] += 1

        queue = deque()

        for i in range(numCourses):
            if indegree[i] == 0:
                queue.append(i)

        nodes_visited = 0
        j = 0
        while queue:
            node = queue.popleft()
            nodes_visited += 1
            order[j] = node
            j += 1

            for neighbour in adj[node]:
                indegree[neighbour] -= 1
                if indegree[neighbour] == 0:
                    queue.append(neighbour)

            indegree[node] -= 1

        return order if nodes_visited == numCourses else []