public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if(num == null || num.length()==0){
            return result;
        }
        
        helper(num, target, "", result, 0, 0, 0);
        return result;
    }
    
    private void helper(String num, int target, String path, List<String> result, int pos, long eval, long lastVal){
        if(pos > num.length()){
            return;
        }   
        
        if(pos == num.length() && eval == target){
            result.add(path);
            return;
        }
        
        for(int i = pos; i<num.length(); i++){
            if(i != pos && num.charAt(pos) == '0'){
                break;
            }
            
            long curr = Long.parseLong(num.substring(pos, i+1));
            if(pos == 0){
                helper(num, target, path + curr, result, i+1, eval+curr, curr);
            }else{
                helper(num, target, path + "+" + curr, result, i+1, eval+curr, curr);
                helper(num, target, path + "-" + curr, result, i+1, eval-curr, -curr);
                helper(num, target, path + "*" + curr, result, i+1, eval-lastVal + lastVal*curr, lastVal*curr);
            }
        }
    }
}