class Solution:
    def leastInterval(self, tasks, n):
        curr_time, h = 0, []
        for v in collections.Counter(tasks).values():
            heapq.heappush(h, -1*v)
        while h:
            temp = []
            for _ in range(n+1):
                curr_time += 1
                if h:
                    x = heapq.heappop(h)
                    if x != -1:
                    # if current element does not used out this time, so there could be idles
                    # and it cannot be used again in this n+1 space, so removed to temp and add back later
                    # we can add all left idles if no h but have temp, to improve time complexity.
                        temp.append(x+1)
                if not h and not temp:#not temp, add idle
                    break
            for item in temp:
                heapq.heappush(h, item)
        return curr_time