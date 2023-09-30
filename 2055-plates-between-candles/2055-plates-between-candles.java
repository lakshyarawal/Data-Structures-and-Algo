class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        
        int[] leftCandles = new int[n];
        int[] rightCandles = new int[n];
        int[] plates = new int[n];
        if(s.charAt(0) == '|') plates[0] = 1;
        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '|')plates[i] = plates[i-1]+1;
            else{
                 plates[i] = plates[i-1];
            }
        }
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|') leftCandles[i] = i;
            else{
                if(i > 0) leftCandles[i] = leftCandles[i-1];
            }
        }
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '|') rightCandles[i] = i;
            else{
                 if (i < n-1)rightCandles[i] = rightCandles[i+1];
            }
        }
        //System.out.println(Arrays.toString(leftCandles));
        //System.out.println(Arrays.toString(rightCandles));
        int[] res = new int[queries.length];
        
        for(int i = 0; i< queries.length; i++){
            if(queries[i][1] == queries[i][0]){
                 res[i] = 0;
                continue;
            }
            res[i] = (leftCandles[queries[i][1]]  - rightCandles[queries[i][0]]);
            res[i] = Math.max(res[i], 0);
            if(res[i] > 0){
                //System.out.println(Arrays.toString(plates));
                res[i] -= (plates[leftCandles[queries[i][1]]] - plates[rightCandles[queries[i][0]]]);
            }
        }
        
        return res;
    }
}