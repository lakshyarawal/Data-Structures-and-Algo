class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean [][]canPacific = new boolean[m][n];
        boolean [][]canAtlantic = new boolean[m][n];   

        for(int i=0;i<m;i++){
            dfs(heights,i,0,canPacific,0);
            dfs(heights,i,n-1,canAtlantic,0);
        }

        for(int i=0;i<n;i++){
            dfs(heights,0,i,canPacific,0);
            dfs(heights,m-1,i,canAtlantic,0);
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(canPacific[i][j]&&canAtlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }

    return list;
    }

    void dfs(int[][]heights,int i,int j,boolean[][]visited,int prevHeight){
            if(i>=0&&j>=0&&i<heights.length&&j<heights[0].length&&!visited[i][j]&&heights[i][j]>=prevHeight){
                visited[i][j]=true;
                dfs(heights,i+1,j,visited,heights[i][j]);
                dfs(heights,i,j+1,visited,heights[i][j]);
                dfs(heights,i-1,j,visited,heights[i][j]);
                dfs(heights,i,j-1,visited,heights[i][j]);
            }
    return;
    }
}