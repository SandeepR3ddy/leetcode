class Solution {
    
    public void dfs(int i , int j, int[][] grid)
    {
        
        grid[i][j] = 0;
        
        if(i-1 > 0 && grid[i-1][j] == 1)
        {
            dfs(i-1,j,grid);
        }
        
        if(j-1 > 0 && grid[i][j-1] == 1)
        {
            dfs(i,j-1,grid);
        }
        
        if(i+1 < grid.length && grid[i+1][j] == 1)
        {
            dfs(i+1,j,grid);
        }
        
        
        if(j+1 < grid[0].length && grid[i][j+1] == 1)
        {
            dfs(i,j+1,grid);
        }
        
        return;
    }
    
    
    
    public int numEnclaves(int[][] grid) {
          
           int rows = grid.length;
           int cols = grid[0].length;
        
            for(int i = 0;i < rows;i++)
            {
                for(int j = 0;j < cols;j++)
                {
                    if((i == 0 || j == 0 || i == rows-1 || j == cols-1) && grid[i][j] == 1)
                    {
                        dfs(i,j,grid);
                    }
                }
            }
        int count  = 0;
        
        
            for(int i = 0;i < rows;i++)
            {
                for(int j = 0;j < cols;j++)
                {
                   if(grid[i][j] == 1)
                   {
                       count++;
                   }
                }
            }
        return count;
    }
}