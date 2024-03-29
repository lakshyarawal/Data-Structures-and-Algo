class Solution {
    public int subsetTargetSum;
  public boolean canPartitionKSubsets(int[] nums, int k) {
    final int sum = Arrays.stream(nums).sum();
    if (sum % k != 0)
      return false;

    final int t = sum / k; // Each subset's target sum
      subsetTargetSum = t;
    boolean[] seen = new boolean[nums.length];
    return dfs(nums, 0, k, t, seen);
  }

  private boolean dfs(int[] nums, int s, int k, int target, boolean[] seen) {
    if (k == 0)
      return true;
    if (target < 0)
      return false;
    if (target == 0)
      return dfs(nums, 0, k - 1, subsetTargetSum, seen);

    for (int i = s; i < nums.length; ++i) {
      if (seen[i])
        continue;
      seen[i] = true;
      if (dfs(nums, i + 1, k, target - nums[i], seen))
        return true;
      seen[i] = false;
    }

    return false;
  }
}