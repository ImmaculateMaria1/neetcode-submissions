class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] == '1'){
                    islands++;
                    dfs(i,j,grid);
                }
            }
        }

        return islands;
    }


    public void dfs(int rows, int cols, char[][] grid){
        int newRow = grid.length;
        int newCol = grid[0].length;

        int[][] directions = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};

        if(rows < 0 || cols < 0 || rows >= newRow || cols >= newCol || grid[rows][cols] == '0'){
            return;
        }

        grid[rows][cols] = '0';

        for(int[] dir : directions){
            dfs(rows+dir[0],cols+dir[1],grid);
        }
    }
}
