class Solution {
    public int twoEggDrop(int n) {
        int i = 0;
        int moves = 0;
        while(i < n){
            n = n - i;
            moves++;
            i++;
        }
        return moves;
    }
}