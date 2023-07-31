class TimeMap {
    class entry implements Comparable<entry> {
        int time;
        String value;

        public entry(String val, int time) {
            this.time = time;
            this.value = val;
        }

        @Override
        public int compareTo(entry e) {
            return e.time - this.time;
        }
    }

    
    HashMap<String, List<entry>> timeValueMap;
    
    public TimeMap() {
        timeValueMap = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        if(!timeValueMap.containsKey(key)){
            timeValueMap.put(key, new ArrayList<entry>());
        }
        timeValueMap.get(key).add(new entry(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if(!timeValueMap.containsKey(key) || timeValueMap.get(key).get(0).time > timestamp){
            return "";
        }
        int left = 0;
        int right = timeValueMap.get(key).size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (timeValueMap.get(key).get(mid).time <= timestamp) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // If iterator points to first element it means, no time <= timestamp exists.
        if (right == 0) {
            return "";
        }
                
        return timeValueMap.get(key).get(right - 1).value;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */