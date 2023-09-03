class Solution {
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        int[][] directions = new int[][]{{1,0} , {-1,0} ,{0,1} ,{0,-1}};
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    int area = 1;
                    q.add(new Pair(i, j));
                    while(!q.isEmpty()){
                        Pair<Integer, Integer> p = q.poll();
                        int x = p.getKey();
                        int y = p.getValue();
                        for(int[] dir : directions){
                            int newRow = x + dir[0];
                            int newCol = y + dir[1];
                            if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n){
                                if(grid[newRow][newCol] == 1){
                                    q.add(new Pair(newRow, newCol));
                                    grid[newRow][newCol] = 0;
                                    area++;
                                }   
                            }
                        }        
                    }
                    maxArea = Math.max(area, maxArea);
                    //System.out.println("MAX_AREA: "+ maxArea);
                }
                
            }
        }

        return maxArea;
    }
}