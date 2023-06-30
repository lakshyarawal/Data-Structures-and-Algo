class Solution {
    boolean[] vis;
    void dfs(int[] nums, int cur, List<List<Integer>> res, List<Integer> sub) {
        if (cur == nums.length) {
            res.add(new ArrayList(sub));
            return;
        }
        vis[cur] = true;
        sub.add(nums[cur]);
        dfs(nums, cur + 1, res, sub);
        sub.remove(sub.size() - 1);
        vis[cur] = false;
        dfs(nums, cur + 1, res, sub);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        vis = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> sub = new ArrayList<Integer>();
        dfs(nums, 0, ret, sub);
        return ret;
    }
}