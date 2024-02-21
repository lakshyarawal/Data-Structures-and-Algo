class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        start = 0
        end = 0
        INT_MAX = 100_000_000
        res = INT_MAX
        seen_cards = {}
        while end < len(cards):
            if cards[end] in seen_cards:
                # Found a duplicate card, update the result
                res = min(res, end - seen_cards[cards[end]] + 1)
                # Move the start pointer if necessary (not strictly needed in this version)
                start = max(start, seen_cards[cards[end]] + 1)

            # Update the last seen index of the current card
            seen_cards[cards[end]] = end
            end += 1
        
        return res if res != INT_MAX else -1