class Solution {
    public int reverse(int x) {
        double ans = 0;
        while(x!=0){
            double digit = x%10;
            ans = (ans*10)+digit;
            if(ans>=Integer.MAX_VALUE || ans<=Integer.MIN_VALUE){
                return 0;
            }
            x /=10;
        }
        return (int)ans;
    }
}