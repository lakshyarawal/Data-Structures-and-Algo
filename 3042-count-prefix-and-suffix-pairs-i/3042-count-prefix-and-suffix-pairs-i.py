class Solution:
    def isPrefixAndSuffix(self, str1, str2) -> bool:
        if len(str1) > len(str2):
            return False
        l1 = len(str1)
        if str2[:l1] == str1 and str2[-l1:] == str1:
            return True
        return False
    
    def countPrefixSuffixPairs(self, words: List[str]) -> int:
        res = 0
        for i in range(len(words)-1):
            for j in range(i+1, len(words)):
                if self.isPrefixAndSuffix(words[i], words[j]):
                    res += 1
        return res