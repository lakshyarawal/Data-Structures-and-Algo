class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, PriorityQueue<Integer>> map = new HashMap<>();
        for (List<String> access: access_times){
            PriorityQueue<Integer> pq = map.computeIfAbsent(access.get(0), s -> new PriorityQueue<>());
            String time = access.get(1);
            int hour = Integer.parseInt(time.substring(0, 2)), minute = Integer.parseInt(time.substring(2, 4));
            pq.offer(hour * 60 + minute);
        }
        List<String> list = new ArrayList<>();
        for (String emp : map.keySet()) {
            PriorityQueue<Integer> pq = map.get(emp);
            if (pq.size() >= 3) {
                int a = pq.poll(), b = pq.poll();
                while (!pq.isEmpty()) {
                    int c = pq.poll();
                    if (c - a < 60) {
                        list.add(emp);
                        break;
                    }
                    a = b;
                    b = c;
                }
            }
        }
        return list;
    }
}