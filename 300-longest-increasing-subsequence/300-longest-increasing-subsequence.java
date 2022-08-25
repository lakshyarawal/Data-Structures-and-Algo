class Solution {
    public int lengthOfLIS(int[] nums) {
        // create an array to store the max increasing length till this point of array
        // iterate through all elements smaller than nums[i] and find the max len in above array
        // keep track of the max length found and add one to it for current element
        
         ArrayList<Integer> sub = new ArrayList<>();
        sub.add(nums[0]);
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                // Find the first element in sub that is greater than or equal to num
                int j = 0;
                while (num > sub.get(j)) {
                    j += 1;
                }
                
                sub.set(j, num);
            }
        }
        
        return sub.size();
    }
}