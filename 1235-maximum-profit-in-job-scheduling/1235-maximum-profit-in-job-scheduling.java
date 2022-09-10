import java.util.Collections;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Create a combined array to store all values of a job
        int n = endTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++){
            jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        
        // Sort the array based on their end time 
        //to compare max profit till that time
        
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        
        // Create a DP array to store the max profit till that time
        
        TreeMap<Integer, Integer> maxProfit = new TreeMap<>();
        
        // Iterate and populate the dp array
        maxProfit.put(0, 0);
        for(int[] job: jobs){
            // Iterate the job array and see which end time is before the given time
            
            int val = job[2] + maxProfit.floorEntry(job[0]).getValue();
            if(val > maxProfit.lastEntry().getValue()){
                maxProfit.put(job[1], val);
            }
        }
        
        return maxProfit.lastEntry().getValue();
    }
}