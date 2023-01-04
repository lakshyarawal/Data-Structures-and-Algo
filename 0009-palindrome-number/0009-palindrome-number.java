class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        boolean isPal = false;
        int[] arr = new int[32];
        int j = 0;
        while(x > 0){
            int i = x%10;
            arr[j] = i;
            j++;
            x = x/10;
        }
        int start = 0;
        int end = j-1;
        while(start < end){
            if(arr[start] != arr[end]) return false;
            start++;
            end--;
        }
        return true;
    }
}