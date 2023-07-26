class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> edges = new HashMap<>();
        for(int i=0; i<equations.size(); i++){
            String from = equations.get(i).get(0);
            String to = equations.get(i).get(1);
            //a to b
            if(edges.containsKey(from) == false){
                edges.put(from, new HashMap<>());
            }
            edges.get(from).put(to, values[i]);
            //b to a
            if(edges.containsKey(to) == false){
                edges.put(to, new HashMap<>());
            }
            edges.get(to).put(from, 1/values[i]);
        }

        //now standard dfs for queries[i][0] to find queries[i][1]
        int n = queries.size();
        double[] output = new double[n];
        for(int i=0; i<n; i++){
            double[] tmp = new double[1];
            tmp[0] = -1;
            String from = queries.get(i).get(0);
            String to = queries.get(i).get(1);
            dfs(new HashSet<String>(), from, 1, tmp, to, edges);
            output[i] = tmp[0];
        }
        return output;
    }

    private void dfs(HashSet<String> visited, String cur, double val, double[] tmp, String target, HashMap<String, HashMap<String, Double>> map){
        if(visited.contains(cur)){
            return;
        }
        visited.add(cur);
        if(cur.equals(target) && map.containsKey(cur)){
            tmp[0] = val;
            return;
        }
        HashMap<String, Double> curMap = map.get(cur);
        if(curMap == null){
            return;
        }
        for(String neighbour : curMap.keySet()){
            dfs(visited, neighbour, val*curMap.get(neighbour), tmp, target, map);
        }
        return;
    }
}