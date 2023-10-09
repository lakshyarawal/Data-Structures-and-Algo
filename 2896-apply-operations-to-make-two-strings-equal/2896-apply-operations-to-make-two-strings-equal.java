public class Solution {
    public int minOperations(String s1, String s2, int x) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        int n = s1.length();

        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1Chars[i] != s2Chars[i]) {
                diffs.add(i);
            }
        }

        int diffCount = diffs.size();
        if (diffCount % 2 == 1) {
            return -1;
        }
        if (diffCount == 0) {
            return 0;
        }

        double[] dp = new double[diffCount + 1];
        Arrays.fill(dp, Double.POSITIVE_INFINITY);
        dp[diffCount] = 0;
        dp[diffCount - 1] = x / 2.0;

        for (int idx = diffCount - 2; idx >= 0; idx--) {
            dp[idx] = Math.min(dp[idx + 1] + x / 2.0, dp[idx + 2] + diffs.get(idx + 1) - diffs.get(idx));
        }

        return (int) dp[0];
    }
}
