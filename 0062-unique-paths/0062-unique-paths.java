class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int[] prev = new int[n];
        int[] curr = new int[n];
        Arrays.fill(prev, 1);
        curr[0] = 1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j <n; j++){
                curr[j] = prev[j] + curr[j-1];
            }
            prev = curr;
        }
        
        System.out.println(Arrays.toString(curr));
        return curr[n-1];
    }
}