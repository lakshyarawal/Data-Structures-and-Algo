class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;
        
        for(int i = 0; i< bloomDay.length; i++){
            minDay = Math.min(minDay, bloomDay[i]);
            maxDay = Math.max(maxDay, bloomDay[i]);
        }
        while(minDay <= maxDay){
            int mid = minDay + (maxDay - minDay)/2;
            if(isValid(bloomDay, k, m, mid)) maxDay = mid-1;
            else minDay = mid+1;
        }
        Arrays.sort(bloomDay);
        for(int val: bloomDay){
            if(minDay <= val) return val;
        }
        return -1;
    }
        
    public boolean isValid(int a[], int size, int count, int day) {
      int curcount = 0, cursize = 0;
      for (int val : a) {
          if (val <= day) cursize++;
          else cursize = 0;
          if (cursize == size) { cursize = 0; curcount++; }
          if (curcount == count) return true;
      }
      return false;
  }
}