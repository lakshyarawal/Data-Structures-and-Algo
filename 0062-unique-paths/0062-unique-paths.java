class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        
        int[] p = new int[n];
        int[] c = new int[n];
        
        Arrays.fill(p, 1);
        c[0] = 1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j <n; j++){
                c[j] = p[j] + c[j-1];
            }
            p = c;
        }
        
        //System.out.println(Arrays.toString(curr));
        return c[n-1];
    }
}