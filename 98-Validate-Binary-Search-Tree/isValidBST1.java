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
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    
    private boolean isBST(TreeNode root, TreeNode low, TreeNode high){
       if(root==null){
           return true;
       }
       
       if((low != null && root.val <= low.val) || (high!=null && root.val >= high.val)){
            return false;
       }
        
        return isBST(root.left, low, root) && isBST(root.right, root, high);
       
       
    }
    

}