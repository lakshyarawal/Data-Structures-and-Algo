class Solution:
    def divideArray(self, v, k):
        ans = []
        n = len(v)
        v.sort()

        for i in range(0, n, 3):
            a, b, c = v[i:i+3]

            if c - a <= k:
                ans.append([a, b, c])
            else:
                ans.clear()
                return ans
        return ans
        