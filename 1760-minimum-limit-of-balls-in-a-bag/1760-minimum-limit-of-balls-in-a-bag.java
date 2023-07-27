class Solution {

    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = 1_000_000_001;
        while (lo < hi) {
            int size = lo + hi >> 1;
            if (canDivide(nums, size, maxOperations)) {
                hi = size;
            }else {
                lo = size + 1;
            }
        }
        return lo;
    }
    private boolean canDivide(int[] nums, int size, int maxOperations) {
        int cnt = 0;
        for (int balls : nums) {
         // cnt += balls / size - (balls % size == 0 ? 1 : 0);
            cnt += (balls - 1) / size;		 
            if (cnt > maxOperations) {
                return false;
            }
        }
        return true;
    }
}