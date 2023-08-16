class Coord{
    int i;
    int j;
    Coord(int i,int j){
        this.i=i;
        this.j=j;
    }
}
class Solution {
    public Coord getCoord(int p,int n){
        p--;
        int i=p/n;
        if(i%2==0){
            return new Coord(n-p/n-1,p%n);
        }
        else{
            return new Coord(n-p/n-1,n-p%n-1);
        }
    }
    
   public  int bfs(int [][] board){
       //This hashmap is storing minimum moves to reach the number
        HashMap<Integer,Integer> moves=new HashMap<>();
        Queue<Integer> q=new LinkedList<>(); 
        HashSet<Integer> visited=new HashSet<>();
        q.add(1);
        moves.put(1,0);
        while(!q.isEmpty()){
            int num=q.poll();
            int mov=moves.get(num);
            if(num==board.length*board.length)
            return mov;
            visited.add(num);
            for(int i=num+1;i<=Math.min(num+6,board.length*board.length);i++){
                Coord c=getCoord(i, board.length);
                int x=c.i;
                int y=c.j;
                int newnum = board[x][y]== -1 ? i : board[x][y];
                if(visited.contains(newnum))
                continue;
                else{
                    moves.put(newnum,mov+1);
                    q.add(newnum);
                    visited.add(newnum);
                }
            }

        }
        return -1;
    }
    public int snakesAndLadders(int[][] board) {
        return bfs(board);
    }
}