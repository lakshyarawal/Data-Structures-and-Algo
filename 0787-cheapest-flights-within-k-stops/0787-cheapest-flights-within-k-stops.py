class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        # Build the adjacency list
        adj = [[] for _ in range(n)]
        for u, v, w in flights:
            adj[u].append((v, w))
        
        # Initialize distances array with infinity
        min_distance = [float('inf')] * n
        min_distance[src] = 0

        # Queue for BFS
        queue = deque([(src, 0)])
        
        # BFS with maximum k stops
        stops = 0
        while queue and stops <= k:
            size = len(queue)
            for _ in range(size):
                node, cost = queue.popleft()
                for neighbor, price in adj[node]:
                    new_cost = cost + price
                    if new_cost < min_distance[neighbor]:
                        min_distance[neighbor] = new_cost
                        queue.append((neighbor, new_cost))
            stops += 1

        return min_distance[dst] if min_distance[dst] != float('inf') else -1