class Solution {
    private static class Edge {
        String vertex;
        double weight;
        
        public Edge(String vertex, double weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);
            
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                double result = dfs(graph, start, end, visited);
                results[i] = result;
            }
        }
        
        return results;
    }

    private Map<String, List<Edge>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String start = equation.get(0);
            String end = equation.get(1);
            double value = values[i];
            
            // Add edges in both directions with corresponding weights
            graph.putIfAbsent(start, new ArrayList<>());
            graph.get(start).add(new Edge(end, value));
            
            graph.putIfAbsent(end, new ArrayList<>());
            graph.get(end).add(new Edge(start, 1.0 / value));
        }
        
        return graph;
    }

    private double dfs(Map<String, List<Edge>> graph, String curr, String target, Set<String> visited) {
        if (curr.equals(target)) {
            return 1.0;
        }
        
        visited.add(curr);
        List<Edge> neighbors = graph.get(curr);
        
        for (Edge neighbor : neighbors) {
            if (!visited.contains(neighbor.vertex)) {
                double result = dfs(graph, neighbor.vertex, target, visited);
                
                if (result != -1.0) {
                    // Found a valid path, return the product of the current value and result
                    return neighbor.weight * result;
                }
            }
        }
        
        // No valid path found
        return -1.0;
    }
}