
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res_ = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                res_[1] = i;
                res_[0] = map.get(nums[i]);
                return res_;
            }
            else{
                map.put(target-nums[i], i);
            }
        }
        return res_;
    }
}