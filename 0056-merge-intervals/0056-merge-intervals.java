class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int curr_start = intervals[0][0];
        int curr_end = intervals[0][1];
        int j = 0;
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] <= curr_end){
                if(intervals[i][1] > curr_end){
                    curr_end = intervals[i][1];
                }
            }
            else{
                intervals[j][0] = curr_start;
                intervals[j][1] = curr_end;
                j++;
                curr_start = intervals[i][0];
                curr_end = intervals[i][1];
            }
        }
        intervals[j][0] = curr_start;
        intervals[j][1] = curr_end;
        
        return  Arrays.copyOfRange(intervals, 0, j+1);  
    }
}