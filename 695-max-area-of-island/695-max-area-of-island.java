class Solution {
  
    public int dfs(int[][] grid, int i, int j, int[][] dir)
    {
       grid[i][j] = 0; 
        
       int size = 0; 
        
       for(int k = 0;k < dir.length;k++)
       {
          int r = i + dir[k][0];
           int c = j + dir[k][1];
           
           if(r >= 0 && c >= 0 & r < grid.length && c < grid[0].length && grid[r][c] != 0)
           {
              size +=   dfs(grid,r,c,dir);
           }
       
       }
        
        return size+1;
  
    }
    
    
    
    public int maxAreaOfIsland(int[][] grid) {
  
        int n = grid.length, m = grid[0].length;
        
         int max = 0;
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                
                if(grid[i][j] == 1)
                {
                    
                int size = dfs(grid,i,j,dir);
                max = Math.max(size,max);

                }
            }
        }
        
        return max;
    }
}