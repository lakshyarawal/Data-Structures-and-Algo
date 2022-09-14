class Solution {
public:
    bool isValid(int i, int n){
        if(i>=0 && i<n)
            return true;
        return false;
    }
    
    int countSubstrings(string s) {
        int n = s.size();
        int cnt=0;
        for(int i=0;i<n-1;i++){
            for(int j=1; ;j++){
                if(isValid(i+j,n) && isValid(i-j,n) && s[i+j]==s[i-j]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            if(s[i]==s[i+1]){
                cnt++;
                for(int j=1; ;j++){
                    if(isValid(i+1+j,n) && isValid(i-j,n) && s[i+1+j]==s[i-j]){
                        cnt++;
                    }
                    else{
                        break;
                    }
              }
            }
            
        }
        return cnt+n;
    }
};