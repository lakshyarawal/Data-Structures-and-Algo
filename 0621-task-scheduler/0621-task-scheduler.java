public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;  // If the cooldown period is 0, then no waiting is needed.
        
        // Create a map to store the count of each task.
        Map<Character, Integer> taskToCount = new HashMap<>();
        for (char c : tasks) {
            taskToCount.put(c, taskToCount.getOrDefault(c, 0) + 1);
        }
        
        // Create a priority queue to store the counts of tasks in descending order.
        Queue<Integer> queue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (char c : taskToCount.keySet()) queue.offer(taskToCount.get(c));
        
        // Create a map to store the cooldown time remaining for each task.
        Map<Integer, Integer> coolDown = new HashMap<>();
        int currTime = 0;  // Initialize the current time.
        
        // Process tasks and cooldowns until the priority queue is empty and all cooldowns are cleared.
        while (!queue.isEmpty() || !coolDown.isEmpty()) {
            // Check if there's a task that can be released from cooldown and add it back to the queue.
            if (coolDown.containsKey(currTime - n - 1)) {
                queue.offer(coolDown.remove(currTime - n - 1));
            }
            
            // If there are tasks in the queue, process the next task.
            if (!queue.isEmpty()) {
                int left = queue.poll() - 1;  // Decrease the count of the task being processed.
                if (left != 0) coolDown.put(currTime, left);  // If the count is not zero, add it to cooldown.
            }
            
            currTime++;  // Move to the next time unit.
        }
        
        return currTime;  // Return the total time units taken to complete all tasks.
    }
}
