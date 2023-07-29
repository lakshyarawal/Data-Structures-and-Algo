class UndergroundSystem {
    HashMap<Integer, Pair<String, Double>> checkIn;
    HashMap<String, Pair<Double, Integer>> averageTimes;
    
    public UndergroundSystem() {
        checkIn = new HashMap<>();
        averageTimes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Pair(stationName, (double)t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String startS = checkIn.get(id).getKey();
        double startTime = checkIn.get(id).getValue();
        checkIn.remove(id);
        double time = t - startTime;
        
        String key = startS + "|"+stationName;
        
        if(averageTimes.containsKey(key)){
            Pair<Double, Integer> p = averageTimes.get(key);
            double newTime = p.getKey() + time;
            averageTimes.put(key, new Pair(newTime, p.getValue() + 1));
        } else{
            averageTimes.put(key, new Pair(time, 1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String key = startStation +"|"+endStation;
        Pair<Double, Integer> p = averageTimes.get(key);
        return p.getKey()/p.getValue();
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */