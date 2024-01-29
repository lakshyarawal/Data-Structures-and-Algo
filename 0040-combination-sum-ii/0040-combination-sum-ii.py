class Solution:
    def recursive_sum(self, target, res, curr, candidates, start):
        if start == len(candidates) and target != 0:
            return
        if target == 0:
            res.append(curr[:])
            return
        for i in range(start, len(candidates)):
            if i > start and candidates[i] == candidates[i - 1]:
                continue
            if candidates[i] > target:
                break
            curr.append(candidates[i])
            self.recursive_sum(target - candidates[i], res, curr, candidates, i + 1)
            curr.pop()
            
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        candidates.sort()
        res = []
        self.recursive_sum(target, res, [], candidates, 0)
        return res
        