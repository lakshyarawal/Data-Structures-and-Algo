class Solution {
    public void recSum(int k, int n, boolean[] visited, List<Integer> l, List<List<Integer>> res, int start){
        if(n == 0 && k == 0){
            res.add(new ArrayList<Integer>(l));
            return;
        }
        else if(n > 0 && k > 0){
            for(int i = start; i <= 9; i++){
                if(i <= n &&  !visited[i]){
                    //System.out.println("I: "+ i + " N: "+ n);
                    visited[i] = true;
                    l.add(i);
                    recSum(k-1, n - i, visited, l, res, i + 1);
                    l.remove(l.size() - 1);
                    visited[i] = false;
                }
                if(i > n) break;
            }
        }

    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visitedNum = new boolean[10];
        List<Integer> empty = new ArrayList<>();
        recSum(k, n, visitedNum, empty, res, 1);
        return res;
    }
}