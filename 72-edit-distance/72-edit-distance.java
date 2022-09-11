class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(); 
        int l2 = word2.length();
        if(l1 * l2 == 0){
            return l1+l2;
        }
        int[][] disArr = new int[l1+1][l2+1];
        for (int i = 0; i <= l1; i++) {
            disArr[i][0] = i;
        }
        for (int j = 0; j <= l2; j++) {
            disArr[0][j] = j;
        }
        for(int i=1; i<= l1; i++){
            for(int j=1; j<=l2; j++){
                int left = disArr[i - 1][j] + 1;
                int down = disArr[i][j - 1] + 1;
                int left_down = disArr[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                  left_down += 1;
                disArr[i][j] = Math.min(left, Math.min(down, left_down));

                
            }
        }
        System.out.println(Arrays.deepToString(disArr));
        return disArr[l1][l2];
        
    }
}