class Solution:
    def lastNonEmptyString(self, s: str) -> str:
        cnt, last = Counter(s), [] 
        mx = max(cnt.values())
        for c in reversed(s):
            if mx == cnt[c]:
                last.append(c)
                cnt[c] -= 1
        return ''.join(last[:: -1])