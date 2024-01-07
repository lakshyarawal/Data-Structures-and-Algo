class Solution:
    def calculate_time(self, speed, piles):
        t = 0
        for num in piles:
            t += -(-num // speed)  # Equivalent to Math.ceil((double)(num) /(double)(speed))
        return t
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        max_pile = max(piles)
        start, end = 1, max_pile

        while start <= end:
            mid = start + (end - start) // 2
            t = self.calculate_time(mid, piles)

            if t <= h:
                end = mid - 1
            else:
                start = mid + 1

        return start
     