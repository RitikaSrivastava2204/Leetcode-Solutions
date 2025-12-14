class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1) return 1;
        Integer[] dp = new Integer[n+1];
        return climbStairs(n, dp);
    }
    public int climbStairs(int n, Integer[] dp) {
        if(n==0 || n==1) return 1;
        if(dp[n] != null) return dp[n];
        int next = climbStairs(n-1, dp);
        int nextToNext = climbStairs(n-2, dp);
        return dp[n] = next + nextToNext ;
    }
}