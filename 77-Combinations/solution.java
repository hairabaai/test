public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        if(n <= 0 || k == 0 || n < k){
            return result;
        }

        List<Integer> list = new ArrayList<>();
        helper(result, list, n, k, 1);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int n, int k, int pos){
        if(k == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = pos; i < n+1; i++){
            list.add(i);
            helper(result, list, n, k-1, i+1);
            list.remove(list.size()-1);
        }
    }
}