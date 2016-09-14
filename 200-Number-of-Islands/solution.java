public class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null){
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j]=='1'){
                    helper(i, j, grid);
                    count++;
                }
            }
        }
        
        
        return count;
    }
    
    private void helper(int x, int y, char[][] grid){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return;
        }
        if(grid[x][y] != '1'){
            return;
        }
        grid[x][y] = '0';
        
        helper(x+1, y, grid);
        helper(x-1, y, grid);
        helper(x, y+1, grid);
        helper(x, y-1, grid);

    }
}