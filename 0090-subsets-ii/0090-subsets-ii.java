class Solution {
    
    public void dfs(List<List<Integer>> res, List<Integer> curr, int[] nums, int start){
        res.add(new ArrayList<>(curr));
        
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            dfs(res, curr, nums, i + 1);
            curr.remove(curr.size()-1);
        }
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(), nums, 0);
        
        return res;
    }
}