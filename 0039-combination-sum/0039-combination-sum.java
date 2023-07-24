class Solution {
    public void recSum(List<List<Integer>> res, int[] candidates, int target, List<Integer> curr, int start){
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0) return;
        for(int i = start; i < candidates.length; i++){
            curr.add(candidates[i]);
            recSum(res, candidates, target - candidates[i], curr, i);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        recSum(res, candidates, target, new ArrayList<Integer>(), 0);
        return res;
    }
}