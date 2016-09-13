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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();
        helper(root, sum, list, result);
        
        return result;
    }
    
    private void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result){
        if(root == null){
            return;
        }
        
        if(root.left == null && root.right == null && root.val == sum){
            list.add(root.val);
            result.add(new ArrayList<Integer>(list));
            list.remove(list.size()-1);
        }
        
        
        list.add(root.val);
        helper(root.left, sum-root.val, list, result);
        helper(root.right, sum-root.val, list, result);
        list.remove(list.size()-1);
    }
    
}