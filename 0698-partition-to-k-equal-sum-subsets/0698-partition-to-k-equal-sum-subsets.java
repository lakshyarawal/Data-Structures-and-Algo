class Solution {
int sum;
public boolean solve(int nums[],int target,int index,int[] sums){
    if(index==nums.length){
        for(int i=1;i<sums.length;i++){
            if(sums[i] != sums[i-1]) return false;
        }
        return true;
    }
    for(int j=0;j<sums.length;j++){
        if(sums[j]+nums[index]<=target){
            sums[j]+=nums[index];
            if(solve(nums,target,index+1,sums)) return true;
            sums[j]-=nums[index];
        }
        if(sums[j]==0) return false;
    }
    return false;
}
public boolean canPartitionKSubsets(int[] nums, int k) {
    sum=0;
    for(int num:nums){
        sum+=num;
    }
    if(sum%k!=0 || nums.length<k) return false;
    Arrays.sort(nums);
    return solve(nums,sum/k,0,new int[k]);
}
}