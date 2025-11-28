class Solution {
    int count = 0;
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        dfs(0,-1,adj,values,k);
        return count;
    }
    public long dfs(int currNode, int parentNode, List<List<Integer>> adj, int[] values, int k){
        long currSum = values[currNode];
        for(int neighbour : adj.get(currNode)){
            if(neighbour != parentNode){
                currSum += dfs(neighbour, currNode, adj, values, k);
            }
        }
        if(currSum % k == 0){
            count++;
            return 0;
        }
        return currSum;
    }
}