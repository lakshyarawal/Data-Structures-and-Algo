class Solution {
    public long makeSubKSumEqual(int[] arr, int k) {
        int steps = gcd(arr.length,k);
        int numberOfGroups = steps;
        long result=0;
        for(int groupStartIndex=0;groupStartIndex<numberOfGroups;groupStartIndex++)
        {
            int groupSize = arr.length / steps;
            int group[] = new int[groupSize];
            int j=0;
            for(int i=groupStartIndex;i<arr.length;i+=steps)
            {
                group[j] = arr[i];
                j++;
            }
           
            Arrays.sort(group);
            long operationsToEquateNumstoMedian = 0;
            int midIndex = group.length/2;
            int median = group[midIndex];
            for(int el:group)
            {
                operationsToEquateNumstoMedian += Math.abs(median-el);
            }
            result += operationsToEquateNumstoMedian;
        }
        return result;
    }
    private int gcd(int x, int y) {
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return x;
    }
}