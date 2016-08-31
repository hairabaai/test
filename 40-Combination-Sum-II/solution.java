public class Solution {
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if(candidates==null || candidates.length==0){
            return result;
        }
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, result, list, 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> list, int pos){
        if(target<0){
            return;
        }
        
        //when to stop???
        if(target==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }else{
            for(int i=pos; i<candidates.length; i++){
                //剪枝
                if(candidates[i]>target){
                    break;
                }
                
                //make sure candidates set doesn't have duplicate elements
                if(i>pos && candidates[i]==candidates[i-1]){
                    continue;
                }

                list.add(candidates[i]);
                //不能重复，所以pos+1
                helper(candidates, target-candidates[i], result, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}