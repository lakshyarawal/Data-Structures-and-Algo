class Solution {
    int sum=0;
    public int mctFromLeafValues(int[] arr) {

        minSum(arr, 0, arr.length-1);
        return sum;
    }

    int minSum( int[] arr, int i, int j ){
        if(i>j || i>arr.length || j<0)
            return 0;

        if( i == j-1){
            sum += arr[i]*arr[j];
            return Math.max( arr[i], arr[j]);
        }

        if( i==j) return arr[i];

        int maxIndex = i;
        for(int k=i; k<=j; k++){
            if(arr[k]> arr[maxIndex])
                maxIndex = k;
        }

        int maxLeft = minSum(arr, i, maxIndex-1);
        int maxRight = minSum(arr, maxIndex +1, j);

        sum += maxLeft*arr[maxIndex];
        sum += maxRight*arr[maxIndex];

        return arr[maxIndex];
    }
}