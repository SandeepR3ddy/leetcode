class Solution {
    
    public int islandPerimeter(int[][] grid) {
        
         int n = grid.length;
         int m = grid[0].length;
         
        int ones = 0, nbr = 0;
        
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                if(grid[i][j] == 1)
                {
                    ones++;
                    for(int k = 0;k < dir.length;k++)
                    {
                        int r = i + dir[k][0];
                        int c = j + dir[k][1];
                        
                        if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1)
                        {
                            nbr++;
                        }
                    }
                }
            }
        }
        
        return 4*ones-nbr;
        
    }
}