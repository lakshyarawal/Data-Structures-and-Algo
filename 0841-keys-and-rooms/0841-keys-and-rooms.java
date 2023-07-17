class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visitedRoom = new boolean[n];
        Queue<Integer> roomsToVisit = new LinkedList<>();
        roomsToVisit.add(0);
        visitedRoom[0] = true;
        int totalRooms = 1;
        while(!roomsToVisit.isEmpty()){
                int idx = roomsToVisit.poll();
                //System.out.print("IDX: "+ idx);
                List<Integer> newRooms = rooms.get(idx);
                for(int room: newRooms){
                    if(!visitedRoom[room]){
                        roomsToVisit.add(room);
                        visitedRoom[room] = true;
                        totalRooms++;
                        if(totalRooms == n) return true;
                    }
                }
            //System.out.println("NEW");
        }
        return false;
    }
}