public class Solution {
    public String getHint(String secret, String guess) {
        if(secret == null || guess == null || secret.length() != guess.length()) {
            return "0A0B";
        }
        int bulls = 0;
        int cows = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<secret.length(); i++){
            char c = secret.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        
        for(int i=0; i<secret.length(); i++){
            char sChar = secret.charAt(i);
            char gChar = guess.charAt(i);
            
            if(sChar==gChar){
                bulls++;
                map.put(gChar, map.get(gChar)-1);
            }else if(map.containsKey(gChar)){
                cows++;
                map.put(gChar, map.get(gChar)-1);
            }
        }
        
        for(char c: map.keySet()) {
            if(map.get(c) < 0) {
                cows += map.get(c);
            }
        }
        return String.valueOf(bulls) + "A" + String.valueOf(cows) + "B";
        
    }
}