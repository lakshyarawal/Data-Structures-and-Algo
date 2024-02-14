class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill.sort()
        start = 0
        end = len(skill) -1
        total = skill[start] + skill[end]
        res = skill[start] * skill[end]
        start += 1
        end -= 1
        while start < end:
            if skill[start] + skill[end] != total:
                return -1
            res += skill[start] * skill[end]
            start += 1
            end -= 1
            
        return res