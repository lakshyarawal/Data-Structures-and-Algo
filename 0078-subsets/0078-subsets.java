class Solution {
    void dfs(int[] nums, int cur, List<List<Integer>> res, List<Integer> sub) {
        if (cur == nums.length) {
            res.add(new ArrayList(sub));
            return;
        }
        sub.add(nums[cur]);
        dfs(nums, cur + 1, res, sub);
        sub.remove(sub.size() - 1);
        dfs(nums, cur + 1, res, sub);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(nums, 0, ret, new ArrayList<Integer>());
        return ret;
    }
}