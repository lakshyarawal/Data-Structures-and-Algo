class Solution {

    public boolean backspaceCompare(String s, String t) {
        int charIdx1 = 0, charIdx2 = 0;
        char[] sChars = s.toCharArray(); // Convert strings to char arrays
        char[] tChars = t.toCharArray();

        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != '#') {
                sChars[charIdx1] = sChars[i];
                charIdx1++;
            } else {
                if (charIdx1 > 0) {
                    charIdx1--;
                }
            }
        }

        for (int i = 0; i < tChars.length; i++) {
            if (tChars[i] != '#') {
                tChars[charIdx2] = tChars[i];
                charIdx2++;
            } else {
                if (charIdx2 > 0) {
                    charIdx2--;
                }
            }
        }

        String newS = new String(sChars, 0, charIdx1); // Create new strings from modified char arrays
        String newT = new String(tChars, 0, charIdx2);

        return newS.equals(newT);
    }
}
