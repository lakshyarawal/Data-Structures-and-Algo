class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # Empty Array for storing results
        res = []
        # sorting the Array in ascending order
        nums.sort()
        # Iterating from 0 to n-2 for all possible triplet combinations
        for i in range(len(nums)-2):
            # If num[i] is = to nums[i-1] then this case has been covered already
            if i > 0 and nums[i] == nums[i-1]:
                continue
            # Moving from one ahead of i and last element to find all combinations
            l, r = i+1, len(nums)-1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                # The number is negative and we have to increase it so move towards +ve
                if s < 0:
                    l +=1 
                # The number is positive and we have to decrease it so move towards -ve
                elif s > 0:
                    r -= 1
                # We have found the desired triplet
                else:
                    res.append((nums[i], nums[l], nums[r]))
                    # Skipping all solutions with the same value
                    while l < r and nums[l] == nums[l+1]:
                        l += 1
                    while l < r and nums[r] == nums[r-1]:
                        r -= 1
                    l += 1; r -= 1
        return res