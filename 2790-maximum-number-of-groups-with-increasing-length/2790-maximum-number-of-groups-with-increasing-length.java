class Solution {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int l=0;
        int ans=0;
        int r = 1000000000;
        while(l<=r){
            int mid= (l+r)/2;
            if(check(mid,usageLimits,1)){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
        
    }

    public boolean check(int n, List<Integer> al,int start){
        int tmp=start;
        ArrayList<Integer> al1 = new ArrayList<>();
        if(n > al.size()) return false;
        int ex=0;
        for(int i=0;i<al.size();i++){
           if(tmp<=al.get(i)){
                ex +=  al.get(i) - tmp;
                tmp++;
           }else{
               if(ex+al.get(i) >= tmp){
                 ex -= tmp-al.get(i);  
                 tmp++;
               }else{
                   ex += al.get(i);
               }
               
           }
       }
       if(tmp>n) return true;
       return false;
    }
}