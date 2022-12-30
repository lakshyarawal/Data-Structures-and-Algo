class Solution {
    public int[] sumZero(int n) {
        int[] sum_arr = new int[n];
        for(int i = 0; i< n/2; i++){
            sum_arr[i] = i+1;
            sum_arr[n-i-1] = -(i+1);
        }
        if(n %2 != 0){
            sum_arr[n/2] = 0;
        }
        return sum_arr;
    }
}