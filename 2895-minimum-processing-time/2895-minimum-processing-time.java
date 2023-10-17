class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        int res = Integer.MIN_VALUE;
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int prev = tasks.size()-1;
        for(int i = 0; i < processorTime.size(); i++){
            int p = processorTime.get(i);
            for(int j = prev; j > prev-4; j--){
                res = Math.max(res, p + tasks.get(j));
            }
            prev -= 4;
        }
        return res;
    }
}