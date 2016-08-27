public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length !=9 || board[0].length != 9){
            return false;
        }
        
        Set<Character> rows = new HashSet<>();
        Set<Character> cols = new HashSet<>();
        Set<Character> blocks = new HashSet<>();
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                
                if(board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                
                int rowIndex = i / 3;
                int colIndex = i % 3;
                int blockNum = rowIndex * 3 + j / 3;
                int blockIndex = colIndex * 3 + j % 3;
                
                if (board[blockNum][blockIndex] != '.' && !blocks.add(board[blockNum][blockIndex])) {
                    return false;
                }
                
               
            }
            rows.clear();
            cols.clear();
            blocks.clear();
        }
        return true;
    }
}