public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null){
            return false;
        }
        
        //stop, when s is empty meaning we tried all the subsets ??
        if(s.length()==0){
            return true;
        }
        
        for(int i = 0; i < s.length(); i++){
            //front: 0->i, substring(0, i+1)
            String front = s.substring(0, i+1);
            if(wordDict.contains(front)){
                if(wordBreak(s.substring(i+1, s.length()), wordDict)){
                    return true;
                }
                wordDict.remove(front);
            }
        }
        return false;
    }
}