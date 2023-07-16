class Solution {
  int left = 0;
  int right = 1;
  int max = 0;
  TreeMap<Integer, Set<String>> lengthToForbidden = new TreeMap<>();

  public int longestValidSubstring(String word, List<String> forbidden) {
    createLengthToForbidden(forbidden);
    while (right < word.length()) {
      checkInvalidSubstrings(word);
      ++right;
    }
    checkInvalidSubstrings(word);
    return max;
  }

  private void createLengthToForbidden(List<String> forbidden) {
    for (String forbiddenString : forbidden) {
      int length = forbiddenString.length();
      if (!lengthToForbidden.containsKey(length)) {
        lengthToForbidden.put(length, new HashSet<>());
      }
      lengthToForbidden.get(length).add(forbiddenString);
    }
  }

  private void checkInvalidSubstrings(String word) {
    Integer forbiddenLength = lengthToForbidden.firstKey();
    while (forbiddenLength != null && forbiddenLength <= right - left) {
      String substring = word.substring(right - forbiddenLength, right);
      if (lengthToForbidden.get(forbiddenLength).contains(substring)) {
        left = right - forbiddenLength + 1;
        break;
      }
      forbiddenLength = lengthToForbidden.higherKey(forbiddenLength);
    }
    max = Math.max(max, right - left);
  }
}