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
    List<Integer> nodeVal = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        
        if(root == null){
            return 0;
        }
        
        inorder(root, k);
        return nodeVal.get(k-1);
        
    }
    
    private void inorder(TreeNode root, int k){
        if(nodeVal.size()>=k)
            return;
        if(root == null)
            return;
        inorder(root.left, k);
        nodeVal.add(root.val);
        inorder(root.right, k);
    }
}