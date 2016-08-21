public class Solution {
    public int largestRectangleArea(int[] heights) {
        //create a non-descreasting stack, store index of the array heights[]
        Stack<Integer> stack = new Stack<>();
        //track index of the heights[]
        int i = 0;
        int maxArea = 0;
        //create a array h that is the same with old heights with one extra space. that's why +1 h[heights.length] = 0;
        //we add one '0' in the end
        int[] h = Arrays.copyOf(heights, heights.length+1);
        
        while(i < h.length){
            //when stack is empty or current height >= top of the stack
            if(stack.isEmpty() || h[i] >= h[stack.peek()]){
                stack.push(i++);
            }else{
                int t = stack.pop();
                //if stack is empty. now i = 1
                maxArea = Math.max(maxArea, h[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return maxArea;
    }
}