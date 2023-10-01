class Solution {

    boolean isCyclic(char chrStr1, char chrStr2){

        char nextCyclicChr = (char)(((((chrStr1 - 'a') + 1) + 26) % 26) + 'a');
        return nextCyclicChr == chrStr2;
    }

    public boolean canMakeSubsequence(String str1, String str2) {

        int m = str1.length();
        int n = str2.length();

        int lenCovered = 0;
        for(int i = 0; i < m; i++){

            if(lenCovered == n) return true;

            if(str1.charAt(i) == str2.charAt(lenCovered)) lenCovered++;
            else if(isCyclic(str1.charAt(i), str2.charAt(lenCovered))) lenCovered++;

        }
        
        return lenCovered == n;
    }
}