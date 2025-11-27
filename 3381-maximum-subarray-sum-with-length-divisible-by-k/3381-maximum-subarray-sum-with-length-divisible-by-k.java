class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long runningSum = 0;
        long maxSum = Long.MIN_VALUE;

        // This array stores the SMALLEST prefix sum we have seen for each remainder (0 to k-1)
        // We initialize it with a very large number so the first value we find will replace it.
        long[] minPrefixSum = new long[k];
        for (int i = 0; i < k; i++) {
            minPrefixSum[i] = Long.MAX_VALUE;
        }

        // IMPORTANT: For the very start (before we pick any numbers), the sum is 0.
        // The index is considered "-1", but practically, we treat the start as having remainder k-1 
        // or effectively handling the first block separately. 
        // To make it simple: We can treat index -1's prefix sum as 0.
        // But usually, it's easier to just loop and handle updates carefully.
        
        // Let's initialize "remainder 0" case carefully if we consider 1-based indexing
        // or just handle the loop logic naturally.
        
        // Simpler setup:
        // We will store minPrefixSum based on (index + 1) % k
        // Initial state: Pre-array sum is 0 at index -1.
        // (-1 + 1) % k = 0. So minPrefixSum[0] starts at 0.
        minPrefixSum[0] = 0; 
        
        // Loop through the array
        for (int i = 0; i < nums.length; i++) {
            runningSum += nums[i];
            
            // Current position is 'i'. The length so far is i+1.
            // We want to find a previous spot 'j' such that (i+1) and 'j' have the same remainder.
            int remainder = (i + 1) % k;
            
            // 1. Check if we can make a valid subarray
            if (minPrefixSum[remainder] != Long.MAX_VALUE) {
                long currentSubarraySum = runningSum - minPrefixSum[remainder];
                if (currentSubarraySum > maxSum) {
                    maxSum = currentSubarraySum;
                }
            }
            
            // 2. Update the minimum prefix sum for this remainder
            // If the current running sum is lower than what we saw before for this remainder, save it.
            if (runningSum < minPrefixSum[remainder]) {
                minPrefixSum[remainder] = runningSum;
            }
        }
        
        // If we found no valid subarray (maxSum is still MIN_VALUE), return 0
        if (maxSum == Long.MIN_VALUE) return 0;
        
        return maxSum;
    }
}