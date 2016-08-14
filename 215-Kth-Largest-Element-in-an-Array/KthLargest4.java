public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return o2-o1;
            }
        });
        
        
        for(int num: nums){
            pq.offer(num);
        }
        
        for(int i=0; i<nums.length; i++){
            if(i == k-1){
                return pq.poll();
            }
            pq.poll();
        }
        return 0;
    }
}