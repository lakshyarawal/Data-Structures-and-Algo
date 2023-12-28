class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        left  = 0
        right = n
        result = []
        while(left < n):  # You should loop only until n (the original size of one half)
            result.append(nums[left])
            result.append(nums[right])
            left = left + 1
            right = right + 1
        return result