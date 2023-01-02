class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] count_t = new int[6];
        int[] count_b = new int[6];
        int common = 0;
        count_t[tops[0]-1]++;
        if(tops[0] != bottoms[0]) count_b[bottoms[0]-1]++;
        else common = 1;
        int max_el = -1;
        
        boolean isPossible = false;
        for(int i = 1; i < tops.length; i++){
            isPossible = false;
            count_t[tops[i]-1]++;
            if(tops[i] != bottoms[i]){
                count_b[bottoms[i]-1]++;
            }else{
                common++;
            }
            //System.out.println(i);
            //System.out.println("Tops: "+ Arrays.toString(count_t));
            //System.out.println("Bottoms: "+ Arrays.toString(count_b));
            for(int j = 0; j<6; j++){
                if(count_t[j] + count_b[j] == i+1){
                    isPossible = true;
                    max_el = j;
                }
            }
            if(!isPossible){
                return -1;
            }
        }
        if(isPossible){
            if(count_t[max_el] > count_b[max_el] + common){
                return tops.length - count_t[max_el];
            }
            else{
                return tops.length - (count_b[max_el] + common);
            }
        }
        return -1;
    }
}