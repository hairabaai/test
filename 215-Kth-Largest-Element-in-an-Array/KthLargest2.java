public class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numbers = new ArrayList<>();
        for(int num: nums){
            numbers.add(num);
        }
        Collections.sort(numbers);
        return numbers.get(nums.length - k);
    }
}