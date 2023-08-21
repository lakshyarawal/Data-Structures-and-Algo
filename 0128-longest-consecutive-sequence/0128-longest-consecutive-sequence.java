class Solution {
    public int longestConsecutive(int[] num) {
        if(num.length == 0 || num.length == 1) return num.length;
        int res = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);;
                int sum = left + right + 1;
                map.put(n, sum);
                res = Math.max(res, sum);
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                continue;
            }
        }
        return res;
    }
}