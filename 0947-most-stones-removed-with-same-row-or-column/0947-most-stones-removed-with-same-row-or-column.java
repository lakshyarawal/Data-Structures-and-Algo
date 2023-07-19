class Solution {
    int ans;
    public int removeStones(int[][] stones) {
        int len = stones.length;
        ans = len;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) parent[i] = i;
        ans -= helper(0, stones,parent, len);
        ans -= helper(1, stones,parent, len);
        return len - ans;
    }

    public int find(int[] parent, int curindex){
        int temp = curindex;
        while (curindex != parent[curindex]){
            curindex = parent[curindex];
        }parent[temp] = curindex;
        return curindex;
    }

    public int helper(int num, int[][] stones, int[] parent, int len){
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <len; i++){
            int[] curCoor = stones[i];
            if (map.containsKey(curCoor[num])){
                int pindex = find(parent,map.get(curCoor[num]));
                int cindex = find(parent, i);
                if (pindex != cindex){
                    parent[cindex] = parent[pindex];
                    ans ++;
                }
            }else{
                map.put(curCoor[num], i);
            }
        }return ans;
    }

}
