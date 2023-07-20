class Solution {
    
    public void recSum(int target, HashSet<List<Integer>> res, List<Integer> curr, int[] candidates, int start){
        if(start == candidates.length && target != 0)return;
        if(target == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = start; i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            curr.add(candidates[i]);
            recSum(target - candidates[i],res, curr, candidates, i+1);
            curr.remove(curr.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> res = new HashSet<>();
        recSum(target, res, new ArrayList<>(), candidates, 0);
        List<List<Integer>> list = new ArrayList<>();
        list.addAll(res);
        return list;
    }
}