class TrieNode:
    def __init__(self):
        self.end = False
        self.child = [None] * 10

class Solution:
    def __init__(self):
        self.root = TrieNode()

    def longestCommonPrefix(self, arr1, arr2):
        if len(arr2) > len(arr1):
            return self.longestCommonPrefix(arr2, arr1)
        for num in arr1:
            self.add(num)
        max_len = 0
        for num in arr2:
            max_len = max(max_len, self.prefixCount(num))
        return max_len

    def add(self, num):
        cur = self.root
        for ch in str(num):
            index = int(ch)
            if cur.child[index] is None:
                cur.child[index] = TrieNode()
            cur = cur.child[index]
        cur.end = True

    def prefixCount(self, num):
        cur = self.root
        count = 0
        for ch in str(num):
            index = int(ch)
            if cur.child[index] is None:
                return count
            cur = cur.child[index]
            count += 1
        return count
