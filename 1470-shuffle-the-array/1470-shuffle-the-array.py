class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        stack = list()
        j = n
        i = 0
        while i < n:
            stack.append(nums[i])
            stack.append(nums[j])
            j+=1
            i+=1
        return stack