class Solution {
public int leastInterval(char[] tasks, int n) {
     Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < tasks.length; i++) {
        map.put(tasks[i], map.getOrDefault(tasks[i], 0) + 1);
    }
    PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(
            (a,b) -> a.getValue() != b.getValue() ? b.getValue() - a.getValue() : a.getKey() - b.getKey());

    q.addAll(map.entrySet());

    int count = 0;
    while (!q.isEmpty()) {
        int k = n + 1;
        List<Map.Entry> tempList = new ArrayList<>();
        while (k > 0 && !q.isEmpty()) {
            Map.Entry<Character, Integer> top = q.poll(); // most frequency task
            top.setValue(top.getValue() - 1); // decrease frequency, meaning it got executed
            tempList.add(top); // collect task to add back to queue
            k--;
            count++; //successfully executed task
        }

        for (Map.Entry<Character, Integer> e : tempList) {
            if (e.getValue() > 0) q.add(e); // add valid tasks 
        }

        if (q.isEmpty()) break;
        count = count + k; // if k > 0, then it means we need to be idle
    }
    return count;
}
}