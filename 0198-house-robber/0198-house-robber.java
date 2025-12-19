class Solution {
    public int rob(int[] nums) {
        int i = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return helperRob(nums, i, dp);
    }
    private int helperRob(int[] nums, int i, int[] dp){
        if(i >= nums.length){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int steal = nums[i] + helperRob(nums,i+2, dp);
        int skip = helperRob(nums, i+1, dp);
        return dp[i] = Math.max(steal,skip);

    }
}