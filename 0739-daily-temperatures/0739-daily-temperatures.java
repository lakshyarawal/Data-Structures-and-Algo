class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        PriorityQueue<int[]> smallestTemperature = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int size = temperatures.length;
        int[] res = new int[size];
        smallestTemperature.offer(new int[]{0, temperatures[0]});
        for(int iterator = 1; iterator < size; iterator++){
            while(!smallestTemperature.isEmpty()  && smallestTemperature.peek()[1] < temperatures[iterator]){
                res[smallestTemperature.peek()[0]] = iterator - smallestTemperature.peek()[0];
                smallestTemperature.remove();
            }
            smallestTemperature.offer(new int[]{iterator, temperatures[iterator]});
        }
        return res;
    }
}