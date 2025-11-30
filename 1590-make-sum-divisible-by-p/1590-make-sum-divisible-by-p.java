import java.util.HashMap;

class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // 1. Find the remainder we need to remove
        int target = (int)(totalSum % p);
        if (target == 0) return 0; // Already divisible

        // Map stores <Remainder, Last Index seen>
        HashMap<Integer, Integer> map = new HashMap<>();
        // Initialize for the case where the subarray starts from index 0
        map.put(0, -1); 

        long currentSum = 0;
        int minLen = nums.length;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            
            // Calculate current remainder
            int currentMod = (int)(currentSum % p);
            
            // 2. Calculate the remainder we need to find in the past
            // formula: (currentMod - target + p) % p handles negative results in Java
            int neededMod = (currentMod - target + p) % p;

            // 3. If we have seen this remainder before, we found a valid subarray
            if (map.containsKey(neededMod)) {
                minLen = Math.min(minLen, i - map.get(neededMod));
            }

            // Update map with current remainder and index
            map.put(currentMod, i);
        }

        // If minLen is still the size of the array, we can't remove the whole array
        return minLen == nums.length ? -1 : minLen;
    }
}