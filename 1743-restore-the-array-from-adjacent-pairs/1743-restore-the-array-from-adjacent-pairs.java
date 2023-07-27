class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> neighbors = new HashMap<>();
        
        for (int[] pair : adjacentPairs) {
            neighbors.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            neighbors.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }

        int[] result = new int[adjacentPairs.length + 1];
        int start = 0;

        for (Map.Entry<Integer, List<Integer>> entry : neighbors.entrySet()) {
            if (entry.getValue().size() == 1) {
                start = entry.getKey();
                break;
            }
        }

        int index = 0;
        int prev = start;
        int prev2 = Integer.MIN_VALUE;

        while (index < result.length) {
            result[index++] = prev;
            for (int neighbor : neighbors.get(prev)) {
                if (neighbor != prev2) {
                    prev2 = prev;
                    prev = neighbor;
                    break;
                }
            }
        }

        return result;
    }
}
