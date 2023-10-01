class Solution {
    public int getMaxLen(int[] nums) {
        int maxLen=0;
        int negative_count=0;
        int index=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                index=i+1;
                negative_count=0;
                continue;
            }
            if(nums[i]<0)
            {
                negative_count++;
            }
            if(negative_count%2==0)
            {
                maxLen=Math.max(maxLen,i-index+1);
            }
        }
        negative_count=0;
        index=nums.length-1;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]==0)
            {
                index=i-1;
                negative_count=0;
                continue;
            }
            if(nums[i]<0)
            {
                negative_count++;
            }
            if(negative_count%2==0)
            {
                maxLen=Math.max(maxLen,index-i+1);
            }
        }

        return maxLen;
    }
}