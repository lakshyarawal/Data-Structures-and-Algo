class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        System.out.println("N: "+ n);
        boolean[] visitedRoom = new boolean[n];
        Queue<Integer> roomsToVisit = new LinkedList<>();
        roomsToVisit.add(0);
        visitedRoom[0] = true;
        int totalRooms = 1;
        while(!roomsToVisit.isEmpty()){
            int c = roomsToVisit.size();
            for(int i = 0; i< c; i++){
                int idx = roomsToVisit.poll();
                //System.out.print("IDX: "+ idx);
                List<Integer> newRooms = rooms.get(idx);
                for(int j =0; j < newRooms.size(); j++){
                    int room = newRooms.get(j);
                    if(!visitedRoom[room]){
                        roomsToVisit.add(room);
                        visitedRoom[room] = true;
                        totalRooms++;
                        if(totalRooms == n) return true;
                    }
                }
            }
            //System.out.println("NEW");
        }
        return false;
    }
}