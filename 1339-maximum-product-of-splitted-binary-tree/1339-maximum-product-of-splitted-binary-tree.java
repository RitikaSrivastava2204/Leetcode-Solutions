/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxProduct(TreeNode root) {
        long[] maxProduct = {Integer.MIN_VALUE};
        HashMap<TreeNode,Integer> nodeSumMap = new HashMap<>();
        int[] totalSum = {findTreeSum(root,nodeSumMap)};
        findMaxSum(root,nodeSumMap,totalSum, maxProduct);
        return (int)(maxProduct[0]%1000000007);

    }
    public void findMaxSum(TreeNode root,HashMap<TreeNode,Integer> nodeSumMap,int[] totalSum, long[] maxProduct){
        if(root==null) return;
        long currSum = (long)nodeSumMap.get(root);
        long remSum = (long)totalSum[0] - currSum;
        if(currSum*remSum > maxProduct[0]){
            maxProduct[0] = currSum*remSum;
        }
        findMaxSum(root.left,nodeSumMap,totalSum,maxProduct);
        findMaxSum(root.right,nodeSumMap,totalSum,maxProduct);
    }
    public int findTreeSum(TreeNode root, HashMap<TreeNode,Integer> nodeSumMap){
        if(root==null) return 0;
        int sum = root.val + findTreeSum(root.left,nodeSumMap) + findTreeSum(root.right, nodeSumMap);
        nodeSumMap.put(root, sum);
        return sum;
    }
}