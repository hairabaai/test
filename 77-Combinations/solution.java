public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result =  new ArrayList<List<Integer>>();
        if(n==0 || k==0){
            return result;
        }
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = i+1;
        }
        List<Integer> list = new ArrayList<>();
        
        helper(result, list, a, k, 0);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> list, int[] a, int k, int pos){
        if(k == 0){
            result.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = pos; i < a.length; i++){
            list.add(a[i]);
            helper(result, list, a, k-1, i+1);
            list.remove(list.size()-1);
        }
    }
}