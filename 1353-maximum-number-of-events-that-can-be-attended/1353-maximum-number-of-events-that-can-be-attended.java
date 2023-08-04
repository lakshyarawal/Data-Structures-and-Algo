class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<Integer> endDates = new PriorityQueue<Integer>();
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int i = 0, res = 0, n = events.length;
        for (int date = 1; date <= 100000; date++) {
            while (!endDates.isEmpty() && endDates.peek() < date)
                endDates.poll();
            while (i < n && events[i][0] == date)
                endDates.offer(events[i++][1]);
            if (!endDates.isEmpty()) {
                endDates.poll();
                ++res;
            }
        }
        return res;
    }
}