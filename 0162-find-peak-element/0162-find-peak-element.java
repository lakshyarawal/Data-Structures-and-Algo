class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = (start+end)/2;
            //System.out.println("Mid: "+ mid);
            if(((mid > 0 && nums[mid] > nums[mid-1]) || (mid == 0)) && ( mid == nums.length-1 || (mid < nums.length-1 && nums[mid] > nums[mid+1]))){
                return mid;
            } else if(mid > 0 && nums[mid-1] > nums[mid] ){
                end = mid-1;
            } else{
                start = mid + 1;
            }
        }
        
        return end;
    }
}