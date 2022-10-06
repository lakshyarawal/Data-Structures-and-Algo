class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, 1);
        int max_res = 1;
        for(int i = 1; i < nums.length; i++){
            int j = i-1;
            while(j >= 0){
                if(nums[j] < nums[i]){
                        res[i] = Math.max(res[i],  1 + res[j]);
                    }
                j--;
                }
             max_res = Math.max(max_res, res[i]); 
            }
             
        System.out.println(Arrays.toString(res));
        return max_res;
    }
}