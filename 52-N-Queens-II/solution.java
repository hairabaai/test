public class Solution {
    private int count = 0;
    
    public int totalNQueens(int n) {
        if (n <= 0) {
            return 0;   
        }
        
        int[] queens = new int[n];
        tryNQueens(queens, 0);
        return count;    
    }
    
    private void tryNQueens(int[] queens, int rowNum) {
        if (rowNum == queens.length) {
            count++;
        } else {
            for (int j = 0; j < queens.length; j++) {
                queens[rowNum] = j;
                //注意此处是rowNum
                if (isValidNQueens(queens,rowNum)) {
                   tryNQueens(queens, rowNum+1); 
                }
            }
        }
    }
    
    private boolean isValidNQueens(int[] queens, int rowNum) {
        for(int i=0; i<rowNum; i++){
            if(queens[i] == queens[rowNum]){
                return false;
            }
            
            if(Math.abs(i-rowNum) == Math.abs(queens[i]-queens[rowNum])){
                return false;
            }
        }
        return true;
    }
    
}