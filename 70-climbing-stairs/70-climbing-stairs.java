class Solution {
    public int climbStairs(int n) {
        // create an array to store how many steps it takes to reach this step
        // for every new array add the number of ways to
        if(n == 1){
            return 1;
        }
        int[] numWays = new int[n];
        numWays[0] = 1;
        numWays[1] = 2;
        for(int i=2; i < n; i += 1){
            numWays[i] = numWays[i-2] + numWays[i-1];
        }
        return numWays[n-1];
    }
}