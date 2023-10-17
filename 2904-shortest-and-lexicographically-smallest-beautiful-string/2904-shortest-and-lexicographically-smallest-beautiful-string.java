class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<String> resultList = new ArrayList<>();
        int minLength = s.length();
        int slow = 0, fast = 0, count = 0; //sliding window
        while (fast < s.length()) {
            if (s.charAt(fast) == '1') {
                count++;
            }

            while (count == k) { //while current window is a match
                if (minLength > fast - slow + 1) {
                    resultList = new ArrayList<>(); //empty the resList if find smaller-size matches
                    minLength = fast - slow + 1;
                } 
                if (fast - slow + 1 == minLength) {
                    resultList.add(s.substring(slow, fast + 1));
                }
                if (s.charAt(slow) == '1') {
                    count--;
                }
                slow++; //increment slow to shrink the window
            }

            fast++;
        }
    
        if (resultList.size() == 0) {
            return "";
        }
        Collections.sort(resultList);
        return resultList.get(0);
    }
}