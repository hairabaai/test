public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (nums==null || nums.length==0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        
        helper(nums, list, result, set);
        return result;
    }
    
    private void helper(int[] nums, List<Integer> list, List<List<Integer>> result, Set<Integer> set) {
        if (list.size()==nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int num : nums) {
            if(set.contains(num)){
                continue;
            }else{
                set.add(num);
                list.add(num);
                helper(nums, list, result, set);
                list.remove(list.size() - 1);
                set.remove(num);
            }
        }
        return;
    }
}