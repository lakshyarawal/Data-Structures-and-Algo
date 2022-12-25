class Solution {
        public double  findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedian(merge(nums1, nums2));
    }
    
    private double findMedian(List<Integer> nums){
        if(nums.size() == 0) return 0;
        if(nums.size() % 2 == 0){
            int index = nums.size()/2;
            return (nums.get(index-1)+nums.get(index))/2.0;
        }else{
            return nums.get(Math.abs(nums.size()/2));
        }
    }
                        
    private List<Integer> merge(int[] nums1, int[] nums2){
        List<Integer> result = new ArrayList<>();
        result = addAll(result, nums1);
        result = addAll(result, nums2);
        Collections.sort(result);
        return result;
    }   
    
    private List<Integer> addAll(List<Integer> result, int[] nums){
        for(int i = 0; i<nums.length; i++){
            result.add(nums[i]);
        }        
        return result;
    }
}