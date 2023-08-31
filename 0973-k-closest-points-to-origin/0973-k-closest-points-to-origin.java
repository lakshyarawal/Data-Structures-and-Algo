class Solution {
    class Point implements Comparable<Point>{
        int x;
        int y;
        double distance;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
            distance = Math.pow(x, 2) + Math.pow(y, 2);
        }
        public int compareTo(Point p){
            return (int)(this.distance - p.distance);
        }
        
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] res = new int[k][2];
        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int[] point : points){
            pq.add(new Point(point[0], point[1]));
        }
        for(int i = 0; i < k; i++){
            Point p = pq.remove();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }
        return res;
    }
}