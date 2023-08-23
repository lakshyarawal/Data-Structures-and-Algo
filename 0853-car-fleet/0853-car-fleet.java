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
        List<Car> allCars = new ArrayList<>();

        for(int i = 0; i < n; i ++){
            double time = (double)(target - position[i])/speed[i];
            //System.out.println("ADDING CAR: AT POSITION: "+ position[i]+ " SPEED: "+ speed[i] + " TIME: "+ time);
            allCars.add(new Car(position[i], speed[i], time));
        }
        Collections.sort(allCars);
        int totalFleets = 1;
        double curFleetTime = allCars.get(allCars.size()-1).time;
        //System.out.println("INITIAL FLEET TIME: "+ curFleetTime);
        for(int i = allCars.size()-2; i >= 0; i--){
            //System.out.println("FOR CAR AT: "+allCars.get(i).position+" FLEET TIME: "+ allCars.get(i).time);
            if(allCars.get(i).time > curFleetTime){
                curFleetTime = allCars.get(i).time;
                totalFleets++;
            }
        }
        return totalFleets;
    }
}