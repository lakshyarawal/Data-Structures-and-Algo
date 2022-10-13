class Solution {
    public int maxProduct(int[] nums) {
        int prev_max = nums[0];
        int prev_min = nums[0];
        int max_product = 0;
        int min_product = 0;
        int final_max = nums[0];
        for(int i=1; i<nums.length; i++){
            max_product = Math.max(Math.max(prev_max*nums[i], prev_min*nums[i]), nums[i]);
            //System.out.println("Min: "+min_product*nums[i]+ " "+max_product*nums[i]);
            min_product = Math.min(Math.min(prev_min*nums[i], prev_max*nums[i]), nums[i]);
            //System.out.println(max_product+ " "+ min_product);
            prev_min = min_product;
            prev_max = max_product;
            final_max = Math.max(max_product, final_max);
        }
        return final_max;
    }
}