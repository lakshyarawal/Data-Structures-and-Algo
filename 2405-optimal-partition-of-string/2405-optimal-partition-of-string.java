class Solution {
    public int partitionString(String s) {
        int[] counts = new int[26];
        int partitions = 1;
        // String cs = "";
        for(int i = 0; i < s.length(); i++){
            if(counts[s.charAt(i)-'a'] > 0){
                // System.out.println("IF: "+ cs);
                // cs = ""+ s.charAt(i);
                partitions++;
                counts = new int[26];
                counts[s.charAt(i)-'a'] = 1;
            }else{
                // cs += s.charAt(i);
                counts[s.charAt(i)-'a'] = 1;
            }
        }
        return partitions;
    }
}