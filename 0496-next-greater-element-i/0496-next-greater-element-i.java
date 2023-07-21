class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); 
        Stack<Integer> st=new Stack<>();
        for(int num: nums2){
            while(!st.empty() && st.peek()<num){
                map.put(st.pop(),num);
            }
            st.push(num);
        }
        int i = 0;
        for (int num: nums1){
            nums1[i] = map.getOrDefault(num,-1);
            i++;
        }
        
        return nums1;
    }
}