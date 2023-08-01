class Solution {
    class DisjointSet {
        int[] rank;
        int[] parent;

        public DisjointSet(int n) {
            rank = new int[n + 1]; // Add +1 to account for 1-based indexing
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        public int find(int node) {
            if (parent[node] != node) {
                parent[node] = find(parent[node]); // Path compression
            }
            return parent[node];
        }

        public void union(int node1, int node2) {
            int pNode1 = find(node1);
            int pNode2 = find(node2);
            if (rank[pNode1] > rank[pNode2]) {
                parent[pNode2] = pNode1;
                rank[pNode1]++; 
            } else if (rank[pNode1] < rank[pNode2]) {
                parent[pNode1] = pNode2;
                rank[pNode2]++; 
            } else {
                parent[pNode2] = pNode1;
                rank[pNode1]++; // Increment rank of pNode1
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = 0;
        int[] res = new int[2];
        for (int i = 0; i < edges.length; i++) {
            n = Math.max(n, Math.max(edges[i][0], edges[i][1])); // Fix n calculation
        }
        DisjointSet dsu = new DisjointSet(n);
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if (dsu.find(node1) == dsu.find(node2)) {
                res = edges[i];
            }
            dsu.union(node1, node2);
        }
        return res;
    }
}
