class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length;
       int n = grid[0].length;
       Integer[][] dp = new Integer[m][n];
       return minPathSum(grid, 0, 0, m, n, dp);
    }
    public int minPathSum(int[][] grid, int i, int j, int m, int n, Integer[][] dp){
        if(i>=m || j>=n){
            return Integer.MAX_VALUE;
        }
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j] != null) return dp[i][j];
        return dp[i][j] = Math.min(minPathSum(grid,i+1,j,m,n,dp), minPathSum(grid,i,j+1,m,n, dp)) + grid[i][j];
        
    }

}