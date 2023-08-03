class Solution {
    class DisjointSet {
        int[] rank;
        char[] parent;

        public DisjointSet(int n) {
            rank = new int[n];
            parent = new char[n];

            for (int i = 0; i < n; i++) {
                parent[i] = (char) ('a' + i); // Use 'a' + i to get the correct character
            }
        }

        public char find(char node1) {
            if (parent[node1 - 'a'] != node1) {
                parent[node1 - 'a'] = find(parent[node1 - 'a']);
            }
            return parent[node1 - 'a'];
        }

        public void union(char node1, char node2) {
            char pNode1 = find(node1);
            char pNode2 = find(node2);

            if (pNode1 == pNode2) {
                return; // Already in the same set
            }

            int idx1 = pNode1 - 'a';
            int idx2 = pNode2 - 'a';

            if (rank[idx1] >= rank[idx2]) {
                parent[idx2] = pNode1;
                rank[idx1]++;
            } else {
                parent[idx1] = pNode2;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {
        DisjointSet dsu = new DisjointSet(26);

        for (String equ : equations) {
            char[] eq = equ.toCharArray();
            if (eq[1] == '=') {
                dsu.union(eq[0], eq[3]);
            }
        }

        for (String equ : equations) {
            char[] eq = equ.toCharArray();
            if (eq[1] == '!') {
                if (dsu.find(eq[0]) == dsu.find(eq[3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
