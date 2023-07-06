class Solution {
    
    class Bug {
        int pos;
        int direction;
        Bug(int v, int d){
            this.pos = v;
            this.direction = d;
        }
    }
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        if(x == 0) return 0;
        int steps = 0;
        int furthest = 100000;
        Queue<Bug> q = new LinkedList<>();
        HashSet<Integer> forbiddenPositions = new HashSet<>();
        HashSet<String> visitedSet = new HashSet<>();
        
        for(int el: forbidden){
            forbiddenPositions.add(el);
        }
        
        q.offer(new Bug(0, 0));
        visitedSet.add(0+"-"+1);
        steps++;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                Bug bug = q.poll();
                
                int nextPosition = bug.pos+a;
                if(nextPosition == x){
                    return steps;
                }
                if(nextPosition >= 0 && nextPosition < furthest && !forbiddenPositions.contains(nextPosition) && visitedSet.add(nextPosition+"-"+1)){
                    q.offer(new Bug(nextPosition, 1));
                }
                    if(bug.direction == 1){
                        int backPosition = bug.pos - b;
                        if(backPosition == x){
                            return steps;
                        }
                        if(backPosition >= 0 && backPosition < furthest && !forbiddenPositions.contains(backPosition) && visitedSet.add(backPosition+"-"+0)){
                            q.offer(new Bug(backPosition, 0));
                        }
                    }
            }
            steps++;
        }
        
        return -1;
        
    }
}