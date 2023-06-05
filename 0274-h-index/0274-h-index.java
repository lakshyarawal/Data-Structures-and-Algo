
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int curr = 0;
        int ind = 0;
        for(int i = citations.length-1; i >=0; i--){
            curr++;
            ind = citations[i];
            h = Math.max(h, Math.min(curr, ind));
        }
        return h;
    }
}