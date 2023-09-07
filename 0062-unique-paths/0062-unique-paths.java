class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        
        int[] prev = new int[n];
        int[] curr = new int[n];
        
        Arrays.fill(prev, 1);
        curr[0] = 1;
        
        while(m > 1){
            for(int j = 1; j <n; j++){
                curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
            m--;
        }
        
        return curr[n-1];
    }
}