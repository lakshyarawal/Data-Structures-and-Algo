class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        skill_est = 2 * sum(skill) // len(skill)        # [1] compute each team's expected skill
        chemistry = 0     
        cnt_values = Counter(skill)                 # [2] count skills

        for key, val in cnt_values.items():          # [3] for all players with a given skill, 
            if val != cnt_values[skill_est-key]:             #     check that there is the same number
                return -1                #     of players with paired skill...
            chemistry += val * key * (skill_est-key)    # [4] ...and compute chemistry for these pairs
            
        return chemistry // 2             # [5] we double-counted, correct for this