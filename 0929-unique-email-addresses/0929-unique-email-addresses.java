class Solution {
    public int numUniqueEmails(String[] emails) {
         HashSet<String> hs = new HashSet();  
        
        for(int i = 0; i< emails.length; i++){
            String curr = emails[i];
            StringBuilder sb = new StringBuilder();
            boolean domain = false;
            boolean isValid = true;
            for(int j = 0; j<curr.length(); j++){
                
                char a = curr.charAt(j);
                
                if(!domain){
                    if(a == '+'){
                        while(j < curr.length() && curr.charAt(j) != '@') j++;
                        sb.append("@");
                        domain = true;
                    }
                    else if(a == '.') continue;
                    else{
                        if(a == '@') domain = true;
                        sb.append(Character.toString(a));
                    }
                }
                else{
                    if(a == '@') isValid = false;
                    sb.append(Character.toString(a));
                }
            }
            System.out.println(sb.toString());
            if(isValid) hs.add(sb.toString());
        }
             
        return hs.size();
    }
}