class Solution {
    public String minRemoveToMakeValid(String s) {
        // Count number of open brackets at all time from left to right
        int openBrackets = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                openBrackets++;
            }
            else if(c == ')' && openBrackets > 0){
                openBrackets--;
            }
            else if(c == ')' && openBrackets <= 0){
                continue;
            }
            sb.append(c);
        }
        int idx = sb.length() - 1;
        //System.out.println("String "+ sb.toString()+" IDX "+idx);
        while(idx >= 0){
            if(openBrackets == 0) break;
            if(sb.charAt(idx) == '('){
                sb.deleteCharAt(idx);
                openBrackets--;
            }
            idx--;
        }
        return sb.toString();
    }
}