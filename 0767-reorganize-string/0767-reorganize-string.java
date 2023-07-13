class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charCount = new HashMap<>();
        
        for(Character c : s.toCharArray()){
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(Map.Entry<Character, Integer> e : charCount.entrySet()){
            pq.offer(new Pair(e.getKey(), e.getValue()));
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first = pq.poll();
            sb.append(first.c);
            Pair second = pq.poll();
            if(second != null){
                sb.append(second.c);
                
            }else if(first.freq > 1){
                return "";
            } 

            if(first.freq > 1){
                first.freq--;
                pq.add(first);
            }
            if(second != null && second.freq > 1){
                second.freq--;
                pq.add(second);
            }
            

        }
        
        return sb.toString();
    }
    
    private static class Pair implements Comparable<Pair>{
        char c;
        int freq;
        
        public Pair(char c, int freq){
            this.c = c;
            this.freq = freq;
        }
        
        @Override
        public int compareTo(Pair o){
            return o.freq - this.freq;
        }
    }


}