class Solution {
    
    //binary search
    //treat this matrix as a sorted array
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int s=0, e = m*n-1;  //0,1
        while(s<=e) {
           
            int mid = s + (e-s)/2;
            int r = mid/n, c = mid%n; //transform mid into r,c pair

            if(target == matrix[r][c]) return true;
            else if (target < matrix[r][c]) 
                e = mid-1;
            else 
                s = mid+1;
        }
        return false;
    }
}