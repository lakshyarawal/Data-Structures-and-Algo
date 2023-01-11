class Solution {
    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length + 1];
        int carry = 1;
        for(int i = digits.length - 1; i>= 0 ; i-- ){
            if(digits[i] + carry > 9){
                result[i+1] = 0;
                carry = 1;
            }
            else {
                result[i+1] = digits[i] + carry;
                carry = 0;
            }
        }
        if(carry == 1){
            result[0] = 1;
            return result;
        }
        return Arrays.copyOfRange(result, 1, result.length);
    }
}