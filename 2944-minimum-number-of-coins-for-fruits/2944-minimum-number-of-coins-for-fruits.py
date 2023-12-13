class Solution:
    def minimumCoins(self, prices: List[int]) -> int:
        queue, cost = collections.deque(), 0
        for index, price in enumerate(prices):
            while queue and queue[0][1] < index:
                queue.popleft()
            cost += price
            while queue and queue[-1][0] > cost:
                queue.pop()
            queue.append((cost, 2 * index + 1))
            cost = min(cost, queue[0][0])
        return cost