class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0, windowSize = cardPoints.length - k, currentSum = 0;
        for (int card : cardPoints) totalSum += card;
        for (int i = 0; i < windowSize; i++) currentSum += cardPoints[i];
        int minSubarraySum = currentSum;
        for (int i = windowSize; i < cardPoints.length; i++) {
            currentSum += cardPoints[i] - cardPoints[i - windowSize];
            minSubarraySum = Math.min(minSubarraySum, currentSum);
        }

        return totalSum - minSubarraySum;
    }
}
