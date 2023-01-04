class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() { 
            @Override
            public int compare(int[] left, int[] right) {
                return getDistance(right) - getDistance(left);
            }
        });
        
        for (int[] point: points) {
            heap.add(point);
            if (heap.size() > k)
                heap.poll();
        }
        
        int[][] result = new int[k][2];
        while (k > 0)
            result[--k] = heap.poll();
        
        return result;
    }
    private int getDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}