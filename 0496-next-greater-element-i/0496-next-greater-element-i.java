class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            valueMap.put(nums2[i], i);
        }
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        for(int j = 0; j < nums1.length; j++){
            for(int i = valueMap.get(nums1[j])+1; i < nums2.length; i++){
                if(nums2[i] > nums1[j]){
                    res[j] = nums2[i];
                    break;
                }
                res[j] = -1;
            }
        }
        return res;
    }
}