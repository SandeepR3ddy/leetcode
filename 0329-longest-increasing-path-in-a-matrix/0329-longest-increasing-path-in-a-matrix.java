class Solution {
    public int longestIncreasingPath(int[][] matrix) {
     
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int[][] indegree = new int[rows][cols];
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        
        for(int i = 0 ;i < rows;i++)
        {
            for(int j = 0;j < cols;j++)
            {
                for(int d = 0;d < dir.length;d++)
                {
                  int nr = i + dir[d][0];
                    int nc = j + dir[d][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && matrix[nr][nc] < matrix[i][j])
                    {
                        indegree[i][j]++;
                    }
                    
                }
                
            }
        }
        
        LinkedList<Integer> que = new LinkedList<>();
        
        int level = 0;
        
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < cols;j++)
            {
                if(indegree[i][j] == 0)
                {
                 que.addLast(i*cols+j);   
                }
            }
        }
        
        while(que.size() > 0)
        {
            int size = que.size();
            
            while(size-- > 0)
            {
                int v = que.removeFirst();
                
                int r =v/cols;
                int c = v%cols;
                
                for(int d = 0;d < dir.length;d++)
                {
                  int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    
                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && matrix[nr][nc] > matrix[r][c] && --indegree[nr][nc] == 0)
                    {
                        
                        que.addLast(nr*cols + nc);
                    }
                    
                }
            }
            
            level++;
            
        }
        
        return level;
    }
}