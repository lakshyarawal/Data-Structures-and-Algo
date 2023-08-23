class Solution {
    class Car implements Comparable<Car>{
        int position;
        int speed;
        double time;
        public Car(int p, int s, double t){
            this.position = p;
            this.speed = s;
            this.time = t;
        }
        @Override
        public int compareTo(Car c){
            return this.position - c.position;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 1 || n == 0) return n;
        List<Car> allCars = new ArrayList<>();
        for(int i = 0; i < n; i ++) allCars.add(new Car(position[i], speed[i], (double)(target - position[i])/speed[i]));
        Collections.sort(allCars);
        int totalFleets = 1;
        double curFleetTime = allCars.get(n-1).time;
        for(int i = allCars.size()-2; i >= 0; i--){
            if(allCars.get(i).time > curFleetTime){
                curFleetTime = allCars.get(i).time;
                totalFleets++;
            }
        }
        return totalFleets;
    }
}