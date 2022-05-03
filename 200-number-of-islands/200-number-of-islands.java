class Solution {
    
    public void dfs(char[][] grid,int row,int col,int[][] dir)
    {
        grid[row][col] = '0';
        
        for(int d = 0;d < dir.length;d++)
        {
           int nrow = row + dir[d][0];
           int ncol = col + dir[d][1];
            
          if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length && grid[nrow][ncol] == '1')
          {
              dfs(grid, nrow, ncol, dir);   
          }
         
        
        }
        
        
    }
    
    
    public int numIslands(char[][] grid) {
        
        int[][] dir = {{0,-1},{0,1},{-1,0},{1,0}};
        int count = 0;
        
        
        for(int i = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid[0].length;j++)
            {
                if(grid[i][j] == '1')
                {
                   dfs(grid,i,j,dir);    
                    count++;
                }
            }
        }
        return count;
    }
}