class Solution {
    public String reorganizeString(String S) {
        int arr[]=new int[26];
        //encoded char in int array(as: 'a'->0,'b'->1,'c'->2----------------'z'->25)
        for(char c : S.toCharArray()) arr[c-'a']++;
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(int i=0;i<26;i++)
            if(arr[i]!=0) pq.add(new int[]{i,arr[i]});
        int last=-1;
        StringBuilder str=new StringBuilder();
        while(!pq.isEmpty()){
            int a[]=pq.poll();
            if(a[0]!=last){
                last=a[0];
                if(a[1]>1)pq.add(new int[]{a[0],a[1]-1});
            }
            else if(pq.isEmpty()) return "";
                 else{
                     int a2[]=pq.poll();
                     last=a2[0];
                     if(a2[1]>1) pq.add(new int[]{a2[0],a2[1]-1});
                     pq.add(a);
                 }
            //decode char from int 
            str.append((char)(last+'a'));
        }
        return str.toString();
    }
}