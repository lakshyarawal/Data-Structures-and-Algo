class Solution:
    
    def maxOperations(self, A: List[int]) -> int:
        @cache
        def go(i = 0, j = len(A) - 1, last = 0):
            if j <= i:
                return 0
            a = 1 + go(i + 2, j, A[i] + A[i + 1]) if not last or last == A[i] + A[i + 1] else 0
            b = 1 + go(i, j - 2, A[j - 1] + A[j]) if not last or last == A[j - 1] + A[j] else 0
            c = 1 + go(i + 1, j - 1, A[i] + A[j]) if not last or last == A[i] + A[j] else 0
            return max(a, b, c)
        return go()