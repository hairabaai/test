public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n==0){
            return result;
        }
        String s = "";
        helper(n, result, s, 0, 0);
        return result;
    }
    
    private void helper(int n, List<String> result, String s, int left, int right){
        if(right == n && left == right){
            result.add(s);
            return;
        }
        
        if(left < n){
            helper(n, result, s+"(", left+1, right);
        }
        //这个条件right< n并不能保证先添加左括号，再添加右括号
        
        if(right < left){
            helper(n, result, s+")", left, right+1);
        }
        
    }
}