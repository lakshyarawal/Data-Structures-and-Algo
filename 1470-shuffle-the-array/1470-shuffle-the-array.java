class Solution {
    public int[] shuffle(int[] nums, int n) {
                //ans[] is used to store output data i.e.SC-O(1)
        int ans[] = new int[nums.length];
        int first = 0;
        int last = n;
        int i=0;
        while(first != n){
            ans[i++] = nums[first++];
            ans[i++] = nums[last++];
        }
        return ans;
    }
}