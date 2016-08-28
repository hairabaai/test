public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        trySolveSudoku(board);
    }
    
    private boolean trySolveSudoku(char[][] board) {
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValidSudoku(board, i, j, num)) {
                            board[i][j] = num;
                            if (trySolveSudoku(board)) { //dfs
                                return true;
                            } else {
                                board[i][j] = '.'; //backtracking
                            }
                        }
                    }
                    return false; //验证了所有的数字以后才能return
                }
            }
        }
        return true;
    }
    
    private boolean isValidSudoku(char[][] board, int row, int col, char c) {
        for (int i=0; i < board.length; i++) {
            if (board[i][col] == c) {
                return false;
            }
        }
        
        for (int j=0; j < board[0].length; j++) {
            if (board[row][j] == c){
                return false;
            }
        }
        
        for (int i = row/3*3; i < row/3*3+3; i++) {
            for (int j = col/3*3; j < col/3*3+3; j++) {
                if (board[i][j] == c){
                    return false;
                }
            }
        }
        return true;
        
    }
}