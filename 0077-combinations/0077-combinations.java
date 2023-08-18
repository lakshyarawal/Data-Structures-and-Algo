class Solution {
    public void dfs(int start, int k,  List<List<Integer>> res,  List<Integer> cur, int n){
        if(cur.size() == k){
            res.add(new ArrayList<>(cur));
            return;
        }
        for(int i = start + 1; i <= n; i++){
            cur.add(i);
            dfs(i, k, res, cur, n);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(0, k, res, new ArrayList<>(), n);
        return res;
    }
}