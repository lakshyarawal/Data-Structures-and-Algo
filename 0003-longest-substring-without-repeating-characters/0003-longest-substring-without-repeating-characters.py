class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l, r = 0, 0
        current_set = set()
        max_len = 0
        while r < len(s):
            if s[r] not in current_set:
                current_set.add(s[r])
                r += 1
                max_len = max(max_len, r - l)
            else:
                current_set.remove(s[l])
                l += 1
        return max_len

        
        