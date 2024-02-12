class Solution(object):
    def shipWithinDays(self, weights, days):

        l=max(weights)
        r=sum(weights)
        res=r

        def check(cap):
            ships=1
            currentcapacity=cap
            for i in weights:
                if currentcapacity-i<0:
                    ships+=1
                    currentcapacity=cap
                currentcapacity-=i
            return ships<=days

        while l<=r:
            mid=l+((r-l)//2)
            if check(mid):
                res=min(res,mid)
                r=mid-1
            else:
                l=mid+1
        return res