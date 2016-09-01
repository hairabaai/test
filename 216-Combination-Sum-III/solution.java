public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
    //k count
    //n target
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k==0 || n==0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        
        helper(k, n, result, list, 0, 1);
        return result;
    }
    
    private void helper(int k, int n, List<List<Integer>> result, List<Integer> list, int pos){
        if(n==0 && k==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }else{
            for(int i=pos; i<10; i++){
                if(i > n){
                    break;
                }
                
                list.add(nums[i]);
                helper(k-1, n-i, result, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}