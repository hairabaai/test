public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n < 0) {
            return res;
        }
        
        int[] queens = new int[n];
        trySolveNQueens(res, queens, 0);
        return res;
    }
    
    //dfs helper
    private void trySolveNQueens(List<List<String>> res, int[] queens, int rowNum) {
        //queens.length=n
        if (rowNum == queens.length){
            collectSolution(res, queens);
        } else {
            for (int j = 0; j < queens.length; j++) {
                queens[rowNum] = j;
                if (isBoardValid(queens, rowNum)) {
                    trySolveNQueens(res, queens, rowNum+1);
                }
            }
        }
    }
    
    private boolean isBoardValid(int[] queens, int rowNum){
        for (int i = 0; i < rowNum; i++) {
            if (queens[i] == queens[rowNum]) {
                return false;
            }
            
            if (Math.abs(queens[i] - queens[rowNum]) == Math.abs(i - rowNum)) {
                return false;
            }
        }
        return true;
    }
    
    private void collectSolution(List<List<String>> res, int[] queens) {
        List<String> sol = new ArrayList<>();
        StringBuilder sb =  new StringBuilder();
        
        for (int i = 0; i < queens.length; i++) {
            sb.setLength(0);
            for (int j = 0; j < queens.length; j++) {
                if (j != queens[i]) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            sol.add(sb.toString());
        }
        res.add(sol);
    }
}