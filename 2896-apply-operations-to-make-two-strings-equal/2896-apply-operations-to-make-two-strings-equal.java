public class Solution {
    int[][] dp = new int[501][501];

    public int solve(int i, int j, int n, List<Integer> v, int x) {
        if (i >= n)
            return 0;
        if (j < 0)
            return 0;
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        int a = v.get(i + 1) - v.get(i) + solve(i + 2, j, n, v, x);
        int b = v.get(j) - v.get(j - 1) + solve(i, j - 2, n, v, x);
        int c = x + solve(i + 1, j - 1, n, v, x);

        dp[i][j] = Math.min(a, Math.min(b, c));
        return dp[i][j];
    }

    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        List<Integer> v = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                v.add(i);
        }

        Arrays.stream(dp).forEach(arr -> Arrays.fill(arr, -1));

        int m = v.size();
        if (m % 2 != 0)
            return -1;

        return solve(0, m - 1, m, v, x);
    }
}
