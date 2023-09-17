class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if(hand.length % groupSize != 0){ // check if the length pof the array is a multiple of k

            return false;
        }

        Map<Integer, Integer> map = new HashMap<>();

        for(int num : hand){ // put all the elements with their count in the map

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(hand);

        // check if the next card of the current element is present in the map or not, if present return true else false;

        for(int num : hand){

            if(map.get(num) > 0){ // check if the count of the current element is > 0 only then we can find its next number

                for (int i = 0; i < groupSize; i++) {

                    int nextcard = num + i; // find the next number of the current element

                    if(map.getOrDefault(nextcard, 0) <= 0){ //if the count of the next element is 0 or -ve,
                        //means we can not make a group from the current number

                        return false;
                    }
                    map.put(nextcard, map.get(nextcard) - 1); // if found, decrease its count by 1.
                }
            }
        }

        return true; // if for all the current number if a group of consecutive numbers of k size can be possible, return true
        
    }
}