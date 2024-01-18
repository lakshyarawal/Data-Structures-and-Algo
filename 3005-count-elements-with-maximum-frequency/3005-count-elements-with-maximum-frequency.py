class Solution:
    def maxFrequencyElements(self, nums: List[int]) -> int:
        freq_dict = {}
        max_freq = 0
        current_items = 0
        for i in nums:
            if i not in freq_dict.keys():
                freq_dict[i] = 1   
            else:
                freq_dict[i] += 1
                
            if freq_dict[i] == max_freq:
                current_items += 1
            elif freq_dict[i] > max_freq:
                max_freq = freq_dict[i]
                current_items = 1
                
        return current_items * max_freq
                