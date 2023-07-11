class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];
        int[][] directions = new int[][]{{-1, 0} , {1, 0} , {0, 1} , {0, -1}};
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        for(int i = 0; i <n; i++){
            for(int j =0; j < n; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = 1;
                    q.offer(new Pair(i, j));
                }
            }
        }
        
        int distance = -1;
        
        while(!q.isEmpty()){
            int qSize = q.size();
            for(int i = 0; i< qSize; i++){
                Pair<Integer, Integer> landCell = q.poll();
                int r = landCell.getKey();
                int c = landCell.getValue();

                for(int[] d : directions){
                    int x = r + d[0];
                    int y = c + d[1];
                    if(x >= 0 && y >= 0 && x < n && y < n && visited[x][y] == 0){
                        visited[x][y] = 1;
                        q.offer(new Pair(x, y));
                    }
                }  
            }
            distance++; 
        }
        
        return distance == 0 ? -1: distance;
    }
}