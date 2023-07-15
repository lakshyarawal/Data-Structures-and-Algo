class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int lastTime = neededTime[0];
        int res = 0;
        
        for(int i = 1; i< colors.length(); i++){
            if(colors.charAt(i) == colors.charAt(i-1)){
                
                res += Math.min(lastTime, neededTime[i]);
                lastTime = Math.max(neededTime[i], lastTime);
                //System.out.println("RES: " + res);
            } else{
                lastTime = neededTime[i];
            }
            
        }
        return res;
    }
}