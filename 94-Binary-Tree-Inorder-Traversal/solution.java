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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) 
            return result;
            
        inorder(root, result);
        return result;
        
        
    }
    
    private void inorder(TreeNode root, List<Integer> result){
        if(root==null)
            return;
        inorder(root.left, result);
        result.add(root.val);
        inorder(root.right, result);
    }
}