public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        helper(result, nums, list, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, int[] nums, List<Integer> list, int pos){
        result.add(new ArrayList<Integer>(list));
        
        for(int i=pos; i<nums.length; i++){
            list.add(nums[i]);
            helper(result, nums, list, i+1);
            list.remove(list.size()-1);
        }
        
    }
}