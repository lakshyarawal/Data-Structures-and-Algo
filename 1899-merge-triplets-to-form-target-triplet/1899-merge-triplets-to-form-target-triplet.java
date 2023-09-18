class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] res = new int[3];
        for(int[] t : triplets){
            boolean canUpdate = true;
            for(int i = 0; i < t.length; i++){
                if(t[i] > target[i]){
                    canUpdate = false;
                    break;
                }
            }
            if(canUpdate){
                for(int i = 0; i < 3; i++){
                    res[i] = Math.max( res[i], t[i]);
                }
            }
        }
        for(int i = 0; i < 3; i++){
            if(res[i] != target[i]) return false;
        }
        return true;
    }
}