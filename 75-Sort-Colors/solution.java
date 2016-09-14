public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length==0){
            return;
        }
        
        int start = 0;
        int end = nums.length-1;
        int index = 0;
        
        while(index <= end){
            if(nums[index] == 0){
                swap(nums, index++, start++);
            }else if(nums[index] == 2){
                swap(nums, index, end--);
            }else{
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int m, int n){
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}