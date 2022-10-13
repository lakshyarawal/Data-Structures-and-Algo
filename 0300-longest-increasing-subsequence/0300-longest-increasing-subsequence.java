class Solution {
    public int lengthOfLIS(int[] nums) {
        //iterate the max_len created yet, to see what is the smallest el in it
        // add one to it and create a new array,
        // find the place for the current element 
        List<Integer> max_list = new ArrayList<>();
        max_list.add(nums[0]);
        for(int i=1; i< nums.length; i++){
            for (int j = max_list.size()-1; j >= 0; j--) {
                if(nums[i] > max_list.get(j)){
                    if(j == max_list.size()-1){
                        max_list.add(nums[i]);
                        break;
                    }
                    else{
                        max_list.set(j+1, Math.min(nums[i], max_list.get(j+1)));
                        break;
                    }
                }
                else if(j-1 >= 0){
                    if(nums[i] > max_list.get(j-1)){
                        max_list.set(j, nums[i]);
                        break;
                    }
                    
                }
                else{
                    if(nums[i] < max_list.get(j)){
                        max_list.set(j, nums[i]);
                    }
                    
                }
            }
            
        }
        return max_list.size();
    }
}