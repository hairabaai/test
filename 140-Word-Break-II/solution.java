public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        
        if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0){
            return result;
        }
        List<String> curr = new ArrayList<>();
        helper(result, curr, s, wordDict, 0);
        return result;
    }
    
    private void helper(List<String> result, List<String> curr, String s, Set<String> wordDict, int pos){
        if(pos == s.length()){
            String solution  = constructString(curr);
            result.add(solution.trim());
            return;
        }
        
        for(int i=pos; i<s.length(); i++){
            String front = s.substring(pos, i+1);
            if(wordDict.contains(front)){
                curr.add(front);
                helper(result, curr, s, wordDict, i+1);
                curr.remove(curr.size()-1);
            }
        }
    }
    
    private String constructString(List<String> tokens){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < tokens.size(); i++){
            sb.append(tokens.get(i) + " ");
        }
        
        return sb.toString();
    }
}