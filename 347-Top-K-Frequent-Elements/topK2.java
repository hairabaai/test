public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        //key:num, value:frequency
        //count the freq of each word
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(!map.containsKey(num)){
                map.put(num, 1);
            }else{
                map.put(num, map.get(num)+1);
            }
        }
        
        //get the max freq to calculate the size of an array
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            max = Math.max(max, entry.getValue());
        }
        
        //initialize an array of ArrayList, index: freq, value: list of nums
        ArrayList<Integer>[] array = (ArrayList<Integer>[])new ArrayList[max+1];
        for(int i=1; i<=max; i++){
            array[i] = new ArrayList<Integer>();
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();
            array[freq].add(num);
        }
        
        for(int j=max; j>=1; j--){
            if(array[j].size()>0){
                for(int a: array[j]){
                    result.add(a);
                }
            }
            
            if(result.size()==k){
                break;
            }
        }
        return result;
        
    }
}