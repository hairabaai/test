public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    //k count
    //n target
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==0 || n==0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        helper(k, n, result, list, 0, nums, 0);
        return result;
    }
    
    private void helper(int k, int n, List<List<Integer>> result, List<Integer> list, int pos, int[] nums, int count){
        if(n==0 && count==k){
            result.add(new ArrayList<Integer>(list));
            count = 0;
            return;
        }else{
            for(int i=pos; i<nums.length; i++){
                if(nums[i] > n){
                    break;
                }
                
                list.add(nums[i]);
                helper(k, n-nums[i], result, list, i+1, nums, count+1);
                list.remove(list.size()-1);
            }
        }
    }
}