class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0 && n==1) return 1;
        int[] a = new int[n+1];
        int judge = -1;
        for(int i = 0; i < trust.length; i++){
            a[trust[i][1]]++;
            if(a[trust[i][1]] == n-1){
                judge = trust[i][1];
            }
        }
        for(int i = 0; i < trust.length; i++){
            if(trust[i][0] == judge) return -1;
        }
        return judge;
    }
}