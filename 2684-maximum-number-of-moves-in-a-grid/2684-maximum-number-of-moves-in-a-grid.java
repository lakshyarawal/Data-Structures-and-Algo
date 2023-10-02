class Solution {
    public int maxMoves(int[][] grid) {
        int cnt=0;
        for(int i=0;i<grid.length;i++){
            cnt=Math.max(cnt,check(i,0,grid,0));
        }
        return cnt-1;
    }
    public static int  check(int i,int j,int grid[][],int prev){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||grid[i][j]<=prev) return 0;
        int prev1=grid[i][j];
        grid[i][j]=(int)1e9;
        int up=check(i-1,j+1,grid,prev1);
        int nxt=check(i,j+1,grid,prev1);
        int down=check(i+1,j+1,grid,prev1);
        // System.out.println(up+" "+nxt+" "+down);
        return Math.max(up,Math.max(nxt,down))+1;
    }
}