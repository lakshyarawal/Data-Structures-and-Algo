class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        d={}
        ans=float('inf')
        n=len(cards)
        for i in range(n):
            if cards[i] in d:
                ans=min(ans,i-d[cards[i]]+2)
            d[cards[i]]=i+1
        return ans if ans!=float('inf') else -1