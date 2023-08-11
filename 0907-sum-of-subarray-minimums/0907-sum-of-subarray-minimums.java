class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] dis = new int[arr.length];
        Stack<int[]> st = new Stack<>();
        for(int i = 0; i< arr.length; i++) {
            while(!st.empty() && st.peek()[0] >= arr[i]) {
                st.pop();
            }
            dis[i] = st.empty() ? i + 1: i - st.peek()[1];
            st.push(new int[]{arr[i], i});
        }
        double count  = 0;
        double[] c = new double[arr.length + 1];
        for(int i = 0; i < arr.length; i++) {
            c[i + 1] = c[i - dis[i] + 1] + arr[i] * (dis[i]);
        }
        for(double d: c) {
            count += d;
        }
        return (int)(count % 1000000007);
    }
}