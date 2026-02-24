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
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = {0};
        StringBuilder binaryString = new StringBuilder("");
        dfs(root, binaryString, sum);
        return sum[0];
        
    }
    public void dfs(TreeNode root, StringBuilder binaryString, int[] sum){
        binaryString.append(root.val);
        if(root.left == null && root.right == null){
            sum[0] = sum[0]+ Integer.parseInt(binaryString.toString(),2);
            return;
        }
        
        if(root.left != null){
            dfs(root.left,binaryString,sum);
            binaryString.deleteCharAt(binaryString.length()-1);
        }
        if(root.right != null){
            dfs(root.right, binaryString, sum);
            binaryString.deleteCharAt(binaryString.length()-1);
        }
        
    }
}