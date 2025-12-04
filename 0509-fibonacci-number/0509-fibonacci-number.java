class Solution {
    
    public int fib(int n) {
        List<Integer> dp = new ArrayList(Collections.nCopies(n+1,null));
        return helperFib(n,dp);
        
    }
    private int helperFib(int n, List<Integer> dp){
        if(n<=1) return n;
        if(dp.get(n) != null){
            return dp.get(n);
        }
        int result = helperFib(n-1, dp) + helperFib(n-2, dp);
        dp.set(n,result);
        return dp.get(n);
    }
}