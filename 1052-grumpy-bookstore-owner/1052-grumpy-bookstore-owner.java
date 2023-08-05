class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int customersSatisfied = 0;
        for(int i = 0; i < customers.length; i++){
            if(grumpy[i] == 0){
                customersSatisfied += customers[i];
            }else{
               grumpy[i] =  customers[i];
            }
        }

        int added = 0;
        
        for(int i = 0; i < minutes && i < grumpy.length; i++){
            added += grumpy[i];
        }
        
        int maxAdded = added;
        int windowStart = 0;
        int windowEnd = minutes-1;
        
        while(windowEnd < grumpy.length-1){
            added -= grumpy[windowStart];
            windowStart++;
            windowEnd++;
            added += grumpy[windowEnd];
            maxAdded = Math.max(maxAdded, added);
        }
        
        return customersSatisfied + maxAdded;
    }
}