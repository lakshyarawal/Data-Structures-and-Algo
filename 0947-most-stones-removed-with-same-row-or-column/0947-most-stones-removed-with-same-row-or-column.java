class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> row = new HashMap<>() , col = new HashMap<>();
        for (int i = 0; i < n; i++){
            row.computeIfAbsent(stones[i][0], o -> new ArrayList<>()).add(i);
            col.computeIfAbsent(stones[i][1], o -> new ArrayList<>()).add(i);
        }

        int numOfIsland = 0;
        for (int i = 0; i < n; i++)
            if (!visited[i]){
                removeIsland(visited, stones, i, row, col);
                numOfIsland++;
            }

        return n - numOfIsland;
    }

    private void removeIsland(boolean[] visited, int[][] stones, int idx,
            Map<Integer, List<Integer>> row, Map<Integer, List<Integer>> col){
        if (visited[idx]) return; // base case

        visited[idx] = true; // mark as visited.
        int r = stones[idx][0];
        int c = stones[idx][1];
        for (int index : row.get(r)) // not null because the current stone is in it
            removeIsland(visited, stones, index, row, col); // visit all the stones on this row

        for (int index : col.get(c))
            removeIsland(visited, stones, index, row, col); // visit all the stones on this col
    }
}