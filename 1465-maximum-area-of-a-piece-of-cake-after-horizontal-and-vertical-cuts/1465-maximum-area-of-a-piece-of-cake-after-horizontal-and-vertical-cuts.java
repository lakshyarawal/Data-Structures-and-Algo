class Solution {
   public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        // Sort the arrays of cuts
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        // Initialize variables for tracking maximum dimensions
        int maxHorizontal = Math.max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.length - 1]);
        int maxVertical = Math.max(verticalCuts[0], w - verticalCuts[verticalCuts.length - 1]);

        // Calculate maximum dimensions between consecutive cuts
        for (int i = 1; i < horizontalCuts.length; i++) {
            maxHorizontal = Math.max(maxHorizontal, horizontalCuts[i] - horizontalCuts[i - 1]);
        }
        for (int i = 1; i < verticalCuts.length; i++) {
            maxVertical = Math.max(maxVertical, verticalCuts[i] - verticalCuts[i - 1]);
        }

        // Calculate and return the maximum area
        return (int) ((long) maxHorizontal * maxVertical % 1_000_000_007);
    }
}