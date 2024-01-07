class Solution:
    def numberGame(self, nums: List[int]) -> List[int]:
        n = sorted(nums)
        arr = [0]*len(nums)
        for i in range(0, len(n)-1, 2):
            arr[i] = n[i+1]
            arr[i+1] = n[i]
        return arr