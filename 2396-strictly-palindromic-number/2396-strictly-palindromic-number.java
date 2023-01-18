class Solution {
    public boolean isStrictlyPalindromic(int n) {
        StringBuilder sb;
        
        for(int i = 2; i < n-1; i++){
            sb = new StringBuilder(String.valueOf(convertDecimalToBinary(n, i)));
            String og = sb.toString();
            String rev = sb.reverse().toString();
            //System.out.println("OG: "+ og + " Rev: "+ rev);
            if(!og.equals(rev)) return false;
            System.out.println();
        }
        return true;
       
    }
    public static long convertDecimalToBinary(int n, int base) {
    
    long binaryNumber = 0;
    int remainder, i = 1, step = 1;

    while (n!=0) {
      remainder = n % base;
      //System.out.println("Step " + step++ + ": " + n + "/"+ base);

        //System.out.println("Quotient = " + n/base + ", Remainder = " + remainder);
        n /= base;

        binaryNumber += remainder * i;
        i *= 10;
    }
    
    return binaryNumber;
    }
}