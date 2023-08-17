class Solution {
    public int binarySearch(int[] row){
        int start = 0;
        int end = row.length-1;
        while(start <= end){
            int mid = (start + end)/2;
            if(row[mid] >= 0){
                start = mid+1;
            } else if(row[mid] < 0){
                end = mid - 1;
            }
        }
        return start;
    }
    
    public int countNegatives(int[][] grid) {
        int totalNegative = 0;
        for(int[] row : grid){
            int idx = binarySearch(row);
            totalNegative += row.length - idx;
        }
        return totalNegative;
    }
}