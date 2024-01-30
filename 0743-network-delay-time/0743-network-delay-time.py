class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        adj = [[] for _ in range(n + 1)]

        for time in times:
            adj[time[0]].append((time[1], time[2]))

        q = deque([k])
        min_time = [float('inf')] * (n + 1)
        min_time[k] = 0

        while q:
            cur_node = q.popleft()
            step_time = min_time[cur_node]

            for n_node in adj[cur_node]:
                if step_time + n_node[1] < min_time[n_node[0]]:
                    min_time[n_node[0]] = step_time + n_node[1]
                    q.append(n_node[0])

        time = 0
        for i in range(1, n + 1):
            if min_time[i] == float('inf'):
                return -1
            time = max(time, min_time[i])

        return time