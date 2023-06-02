class Solution {
    public long numberOfWays(String s) {
        long c = 0;
        long z = 0L;
        long o = 0L;
        long zo = 0L;
        long oz = 0l;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                c+=zo;
                z++;
                oz+=o;
            } else {
                c+=oz;
                o++;
                zo+=z;
            }
        }
        return c;
    }
}