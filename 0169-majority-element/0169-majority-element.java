class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            counts.put(nums[i], counts.getOrDefault(nums[i], 0)+1);
        }
    for (Map.Entry<Integer, Integer> set :
             counts.entrySet()) {
        if(set.getValue() > nums.length/2){
            return set.getKey();
        }
        }
        return -1;
    }
}