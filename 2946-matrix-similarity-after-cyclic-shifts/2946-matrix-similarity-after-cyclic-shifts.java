class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for(int[] m : mat){
            int l = m.length;
            for(int i = 0; i < l; i++){
                if(m[i] != m[(i+k)%l]){
                    return false;
                }
            }
        }
        return true;
    }
}