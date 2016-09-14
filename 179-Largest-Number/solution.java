public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        String[] stringArray = new String[nums.length];
        //turn int array to string array
        for(int i = 0; i < nums.length; i++){
            stringArray[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(stringArray, new Comparator<String>(){
            public int compare(String s1, String s2){
                if(s1.length() > s2.length()){
                    return (-1) * compare(s2, s1);
                }
                String s1s2 = s1 + s2;
                String s2s1 = s2 + s1;
                
                return s2s1.compareTo(s1s2);
                // if(s1s2 > s2s1){
                //     return 1;
                // }else if(s1s2 < s2s1){
                //     return -1;
                // }else{
                //     return 0;
                // }
                
            }
        });
        
        if(stringArray[0].equals("0")){
            return "0";
        }
        
        String res = "";
        for(String item : stringArray){
            res += item;
        }
        return res;
    }
}