class Solution {
    public double angleClock(int hour, int minutes) {
        double hourDegree = (hour * 30 + minutes * 0.5) % 360;
        double minuteDegree = minutes * 6;
        //System.out.println("hourDegree: "+ hourDegree+ " minuteDegree "+ minuteDegree);
        double res = Math.abs(hourDegree-minuteDegree);
        if(res > 180){
            res = 360-res;
        }
        return res;
    }
}