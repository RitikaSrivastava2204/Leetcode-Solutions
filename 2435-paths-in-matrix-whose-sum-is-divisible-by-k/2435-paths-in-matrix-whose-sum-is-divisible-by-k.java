class Solution {
    int MOD = 1000000007; 
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;    
        int n = grid[0].length; 
        Integer[][][] memo = new Integer[m][n][k];
        return solve(grid, 0, 0, m, n, k, 0, memo);
    }
    public int solve(int[][] grid, int i, int j, int m, int n, int k, int currentRem, Integer[][][] memo){
        if(i >= m || j >= n){
            return 0; 
        }
        int newRem = (currentRem + grid[i][j]) % k;
        if(i == m - 1 && j == n - 1){
            if(newRem == 0){
                return 1;
            }
            return 0;
        }
        if(memo[i][j][newRem] != null){
            return memo[i][j][newRem]; 
        }
        int down = solve(grid, i + 1, j, m, n, k, newRem, memo);
        int right = solve(grid, i, j + 1, m, n, k, newRem, memo);
        int totalPaths = (down + right) % MOD;
        memo[i][j][newRem] = totalPaths;
        return totalPaths;
    }
}