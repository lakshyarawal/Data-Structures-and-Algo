class Solution {
    
    HashMap<Character,String> hash=new HashMap<>();
    List<String> list=new ArrayList<>();
    
    public void dfs(String digits,StringBuilder sb,int i){
        if(i==digits.length()){
            list.add(sb.toString());
            return;
        }
        for(char c:hash.get(digits.charAt(i)).toCharArray()){
            sb.append(c);
            dfs(digits,sb,i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return list;
        }
        hash.put('2',"abc");
        hash.put('3',"def");
        hash.put('4',"ghi");
        hash.put('5',"jkl");
        hash.put('6',"mno");
        hash.put('7',"pqrs");
        hash.put('8',"tuv");
        hash.put('9',"wxyz");
        
        dfs(digits,new StringBuilder(),0);
        return list;
    }
}