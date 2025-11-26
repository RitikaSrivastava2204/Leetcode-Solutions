class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length -1;
        int n = obstacleGrid[0].length -1;
        Integer[][] dp = new Integer[m+1][n+1];
        return upwo(obstacleGrid, 0, 0, m, n, dp);
    }
    public int upwo(int[][] obstacleGrid, int i, int j, int m, int n, Integer[][] dp){
        if(i>m || j>n){
            return 0;
        }
        if(i==m && j==n && obstacleGrid[i][j]==0){
            return 1;
        }
        if(obstacleGrid[i][j] == 1){
            return 0;
        }
        if(dp[i][j] != null) return dp[i][j];
        int down = upwo(obstacleGrid, i+1, j, m, n, dp);
        int right = upwo(obstacleGrid, i, j+1, m, n, dp);
        dp[i][j] = down+right;
        return down + right;
    }
}