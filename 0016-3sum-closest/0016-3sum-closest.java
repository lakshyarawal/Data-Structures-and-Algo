class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int result = nums[0] + nums[1] + nums[nums.length -1];
        Arrays.sort(nums);
        int sum = 0;
        int diff = 0;

        for(int i = 0;i<nums.length - 2;i++){
            int ptr1 = i + 1;
            int ptr2 = nums.length -1;

            while(ptr2 > ptr1){
                sum = nums[i] + nums[ptr1] + nums[ptr2];
                if(sum > target){
                    ptr2--;
                }
                else{
                    ptr1++;
                }
                if(Math.abs(sum - target) < Math.abs(result - target)){
                    result = sum;
                }

            }
        }
        return result;
        
    }
}