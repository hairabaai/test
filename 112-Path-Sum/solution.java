/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int sum){
        if(root.left==null && root.right == null && sum==root.val){
            return true;
        }
        boolean left, right = false;
        left = helper(root.left, sum-root.val);
        right = helper(root.right, sum-root.val);
        return left || right;
    }
    
    
    
    

}