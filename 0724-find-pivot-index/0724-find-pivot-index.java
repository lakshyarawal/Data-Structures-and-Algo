class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        if(nums.length == 1) return 0;
        int[] leftSum = new int[n+1];
        int[] rightSum = new int[n+1];
        leftSum[0] = 0;
        rightSum[n] = 0;
        for(int i = 1; i <= n; i++){
            leftSum[i] = nums[i-1] + leftSum[i-1];
            rightSum[n-i] += rightSum[n-i+1] + nums[n-i];
        }
        System.out.println(Arrays.toString(leftSum));
        System.out.println(Arrays.toString(rightSum));
        int pivot = 0;
        while(pivot < n){
            if(leftSum[pivot] == rightSum[pivot+1]) return pivot;
            pivot++;
        }
        return -1;
    }
}