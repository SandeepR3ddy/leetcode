class Solution {

    static int[] parent;
    static int[] size;
    
    public int findParent(int u)
    {
        return parent[u] == u ? u : (parent[u] = findParent(parent[u]));
    }
    
    public int maxAreaOfIsland(int[][] grid) {
    
        int n = grid.length;
        
        if(n == 0)
        {
            return 0;
        }
        
        int m = grid[0].length;
        
        parent = new int[n*m];
        
        size = new int[n*m];
        
        int maxSize = 0;
        
        for(int i = 0;i < n*m;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
        
        int[][] dir = {{0,1},{0,-1},{-1,0},{1,0}};
        
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < m;j++)
            {
                
                if(grid[i][j] == 1)
                {
                int p1 = findParent(i*m + j);
                
                for(int d = 0;d < dir.length;d++)
                {
                    int r = i + dir[d][0];
                    int c = j + dir[d][1];
                    
                    if(r >= 0 && c >= 0 && r < n && c < m && grid[r][c] == 1)
                    {
                        int p2 = findParent(r*m + c);
                        
                        if(p1 != p2)
                        {
                        parent[p2] = p1;
                        
                        size[p1] += size[p2];
                        }
                    }
                }
                
                maxSize = Math.max(maxSize, size[p1]);
                }
            }
        }
        
        
        return maxSize;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
}