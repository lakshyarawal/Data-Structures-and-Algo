class Solution:
    def minimumPushes(self, word: str) -> int:
        n = len(word)
        if(n < 9):
            return n
        # Create a dictionary finding the frequecy of each alphabet in the word
        # Sorting this based on frequency
        # For the first 8 assign 1 value, next 8 2 and the next 8 3 and rest 4
        # multiply these values
        character_frequencies = {}
        for character in word:
            if character in character_frequencies.keys():
                character_frequencies[character] += 1
            else:
                character_frequencies[character] = 1
        sorted_dict_desc = dict(sorted(character_frequencies.items(), key=lambda item: item[1], reverse=True))
        res = 0
        counter = 0
        multiplier = 1
        for key, value in sorted_dict_desc.items():
            res += value * multiplier
            counter += 1
            if counter % 8 == 0:
                multiplier += 1
        #print(sorted_dict_desc)
        return res