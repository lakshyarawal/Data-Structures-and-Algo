class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charFreq.put(c, charFreq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> e : charFreq.entrySet()) {
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair first = pq.poll();
            sb.append(first.c);
            Pair second = pq.poll();
            if (second != null) {
                sb.append(second.c);
            } else if (first.freq > 1) {
                return "";
            }
            // Important to put first before second in the queue. Otherwise if frequencies are equal in the next step the second will be polled before first.
            if (first.freq > 1) {
                first.freq--;
                pq.add(first);
            }
            if (second != null && second.freq > 1) {
                second.freq--;
                pq.add(second);
            }
        }

        return sb.toString();
    }

    private static class Pair implements Comparable<Pair> {
        char c;
        int freq;

        public Pair(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.freq, this.freq);
        }
    }
}