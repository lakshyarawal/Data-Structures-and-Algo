class Solution {
    public long numberOfWays(String s) {
        long ans = 0;
        int len = s.length();
        
        long totZeros = 0;
        char[] ch = s.toCharArray();
        for(int i=0;i<len;i++){
            totZeros += ch[i]=='0'?1:0;
        }
        
        long totOnes = len - totZeros;
        
        long currZeros = ch[0]=='0'?1:0;
        long currOnes = ch[0]=='1'?1:0;
        
        for(int i=1;i<len;i++){
            if(ch[i] == '0'){
                ans = ans + (currOnes * (totOnes-currOnes));
                currZeros++;
            }else{
                ans = ans + (currZeros * (totZeros-currZeros));
                currOnes++;
            }
        }
        return ans;
    }
}