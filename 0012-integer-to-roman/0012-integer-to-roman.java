class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = new String[]{"M","CM", "D","CD", "C","XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder sb = new StringBuilder();
        //System.out.println(vals[0]);
        int i = 0;
        while(num > 0){

            while(num - vals[i] >= 0){
                num = num - vals[i];
                //System.out.println(num);
                sb.append(symbols[i]);
            }
            i++;
        }
        return sb.toString();
    }
}