class Solution {
public long continuousSubarrays(int[] nums) {
        
        Deque<Integer> maxQ = new LinkedList<>(); //  max q
        Deque<Integer> minQ = new LinkedList<>(); // min q

        int jBad = -1;
		
        long count = 0;
        for(int i = 0; i  < nums.length; i++) {
            
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[i])
                maxQ.pollLast();
            
            maxQ.addLast(i);
            
             while(!minQ.isEmpty() && nums[minQ.peekLast()] > nums[i])
                minQ.pollLast();
            
            minQ.addLast(i);
            
            
            if(Math.abs(nums[maxQ.peekFirst()] -  nums[minQ.peekFirst()]) <= 2) 
                count = count + Math.max(0, i - jBad);
            
            else {
                int index = -1;
                if(minQ.peekFirst() == i) {
                    while(!maxQ.isEmpty() && (Math.abs(nums[maxQ.peekFirst()] -  nums[minQ.peekFirst()])) > 2) {
                        int temp  = maxQ.pollFirst();
                        if(temp > jBad && temp > index)
                             index = temp;
                    }
                }
                    
        
                   
                else {
                     while(!minQ.isEmpty() && (Math.abs(nums[maxQ.peekFirst()] -  nums[minQ.peekFirst()])) > 2) {
                        int temp  = minQ.pollFirst();
                        if(temp > jBad && temp > index)
                             index = temp;
                    }
                }
                           
              jBad = index;
              count = count + Math.max(0, i - jBad);              
            }   
        }
      return count;                  
    }
    
}
