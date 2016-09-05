public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if(s==null || s.length()==0){
            return result;
        }
        List<String> list = new ArrayList<>();
        helper(s, result, list, 0);
        return result;    
    }
    
    private void helper(String s, List<List<String>> result, List<String> list, int pos){
        if(pos == s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }
        //因为是从pos+1开始遍历，所以最终值应该是i<=s.length而不是i<s.length
        for(int i=pos+1; i<=s.length();i++){
            String curr = s.substring(pos, i);
            
            if(!isPalindrome(curr)){
                continue;
            }
            
            list.add(curr);
            //因为i已经是pos+1， 所以这是传入helper的是i，而不是i+1
            helper(s, result, list, i);
            list.remove(list.size()-1);
        }
    }
    
    private boolean isPalindrome(String s){
        if(s == null || s.length() == 0){
            return false;
        }
        int m = 0;
        int n = s.length()-1;
        
        while(m < n){
            if(s.charAt(m) == s.charAt(n)){
                m++;
                n--;
            }else{
                return false;
            }
        }
        return true;

    }
    
}