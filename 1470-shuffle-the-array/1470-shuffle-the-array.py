class Solution:
    def shuffle(self, nums: List[int], n: int) -> List[int]:
        new_nums = [] # create an empty list
        for i in range(len(nums)//2): # loop through only half of the list
            new_nums.append(nums[i]) # append the first element
            new_nums.append(nums[i+n]) # append the [i+n]'th element
        return new_nums # returned the filled list