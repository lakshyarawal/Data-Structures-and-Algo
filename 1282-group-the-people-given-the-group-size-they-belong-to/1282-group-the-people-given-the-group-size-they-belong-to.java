class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> results = new ArrayList<>();
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i = 0; i< groupSizes.length; i++){
            if(hm.containsKey(groupSizes[i])){
                List<Integer> temp = hm.get(groupSizes[i]);
                temp.add(i);
                //System.out.println(temp);
                hm.put(groupSizes[i], temp);
            } else{
                List<Integer> new_list = new ArrayList<Integer>();
                new_list.add(i);
                //System.out.println(new_list);
                hm.put(groupSizes[i], new_list);
            }
        }
        for (var entry : hm.entrySet()) {
            //System.out.println( entry.getKey() + "/" + entry.getValue());
            
            int total_size = entry.getKey();
            List<Integer> temp = entry.getValue();
            
            int curr_size = 0;
            List<Integer> n_t = new ArrayList<Integer>();
            
            while(temp.size() > 0 || curr_size == total_size){
                if(curr_size == total_size){
                    results.add(n_t);
                    n_t = new ArrayList<Integer>();
                    curr_size = 0;
                } else{
                    n_t.add(temp.remove(0));
                    curr_size++;
                }
                     
            }
        }
        return results;   
    }
}