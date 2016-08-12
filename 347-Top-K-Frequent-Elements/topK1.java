public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums==null||nums.length==0)
            return result;
            //key element, value frequency
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
      
        PriorityQueue<Integer> pq = new PriorityQueue<>(k+1, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return map.get(o1) - map.get(o2);
            }
        });

        for(int num: map.keySet()){
            pq.offer(num);
            
            if(pq.size()>k){
                pq.poll();
            }
        }
        
        for(int i=0; i<k; i++){
            result.add(0, pq.poll());
        }
        return result;
        
    }
}