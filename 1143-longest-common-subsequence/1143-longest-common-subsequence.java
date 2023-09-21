class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length() < text2.length()){
            String t = text1;
            text1 = text2;
            text2 = t;
        }
        int l1 = text1.length();
        int l2 = text2.length();
        int[] dp = new int[l2];
        
        for(int i=0; i<l1; i++) {
            int prev = 0;
            for(int j=0; j<l2; j++) {
				int tmp = dp[j];
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[j] = prev + 1;
                } else if(j!=0){
                    dp[j] = Math.max(dp[j], dp[j-1]);
                }
				prev = tmp;
            }
        }
        return dp[l2-1];
    }
}