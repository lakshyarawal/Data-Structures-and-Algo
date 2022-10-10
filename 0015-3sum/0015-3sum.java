class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int lo = i+1;
                int high = nums.length-1;
                while(lo < high){
                    if(nums[i] + nums[lo] + nums[high] > 0){
                        high--;
                    }
                    else if(nums[i] + nums[lo] + nums[high] < 0){
                        lo++;
                    }
                    else{
                        result.add(Arrays.asList(nums[i], nums[lo++], nums[high--]));
                        while (lo < high && nums[lo] == nums[lo - 1])
                            ++lo;
                    }
                }
            }
            
        }
        return result;
    }
}