class Solution {
    public int minDeletions(String s) {
        int min_del = 0;
        int[] freq = new int[26];
        for(int i =0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int maxAllowed = s.length();
        for(int j = 25; j>=0 && freq[j] > 0; j--){
            if(freq[j] > maxAllowed){
                min_del += freq[j] - maxAllowed;
                freq[j] = maxAllowed;
            }
            maxAllowed = Math.max(0, freq[j] - 1);
        }
        return min_del;
    }
}