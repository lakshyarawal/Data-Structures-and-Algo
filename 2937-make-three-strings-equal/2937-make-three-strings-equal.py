class Solution:
    def findMinimumOperations(self, s1: str, s2: str, s3: str) -> int:
        max_equal = 0
        for c1, c2, c3 in zip(s1, s2, s3):
            if not (c1 == c2 == c3):
                break
            max_equal += 1
        return -1 if max_equal == 0 else len(s1) + len(s2) + len(s3) - 3 * max_equal