class Solution {
    int maxLen = 0;
    public int maxLength(List<String> arr) {
        if(arr == null || arr.size() == 0) return 0;
        backtracking(arr, 0, new StringBuilder(), new HashSet<Character>());
        return maxLen;
    }
    private void backtracking(List<String> arr, int start, StringBuilder sb, HashSet<Character> set) {
        if (sb.length() > maxLen) maxLen = sb.length();
        for (int i = start; i < arr.size(); i++) {
            boolean add = true;
            HashSet<Character> currSet = new HashSet<>();
            for (char cS : arr.get(i).toCharArray()) {
                if (currSet.contains(cS) || set.contains(cS)){
                    add = false;
                    break;
                }
                currSet.add(cS);
            }
            if (add) {
                sb.append(arr.get(i));
                set.addAll(currSet);
                backtracking(arr, i + 1, new StringBuilder(sb), set);
                set.removeAll(currSet);
                sb.setLength(sb.length() - arr.get(i).length());
            }
        }
    }
}