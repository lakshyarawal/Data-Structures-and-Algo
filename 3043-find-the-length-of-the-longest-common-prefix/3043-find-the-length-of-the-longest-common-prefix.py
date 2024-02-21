class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        pSet = set()
        for num in arr1:
            while num > 0:
                pSet.add(num)
                num //= 10
        max_len = 0
        for num in arr2:
            while num > 0:
                n = len(str(num))
                if n <= max_len:  # if the num itself is less than max no point in checking its prefix
                    break
                if num in pSet:
                    max_len = n
                    break  # no point in checking smaller prefix as they would be less than max anyway
                num //= 10
        return max_len