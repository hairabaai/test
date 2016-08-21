public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n + 1];
        
        int maxArea = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == '0'){
                    heights[j] = 0;
                }else{
                    heights[j]++;
                }
            }
            maxArea = Math.max(maxArea, maxAreaInHist(heights));
        }
        
        
        
        return maxArea;
    }
    
    private int maxAreaInHist(int[] heights){
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int max = 0;
        
        while(i < heights.length){
            if(stack.isEmpty() || heights[i] >= heights[stack.peek()]){
                stack.push(i++);
            }else{
                int t = stack.pop();
                max = Math.max(max, heights[t] * (stack.isEmpty() ? i : i - stack.peek() - 1));
            }
        }
        return max;
    }
}