class Solution:
    def reachingPoints(self, sx: int, sy: int, tx: int, ty: int) -> bool:
        while(tx>=sx and ty>=sy):
            if sx == tx:
                return (ty-sy) % tx == 0
            if sy == ty:
                return (tx-sx) % ty == 0
            if tx>ty:
                tx = tx % ty
            else:
                ty = ty % tx
        return False