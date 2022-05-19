class Solution {
   static int max = 0;
    
    public int longestIncreasingPath(int[][] matrix) {
        
        if(matrix.length == 1 && matrix[0].length == 1)
        {
            return matrix[0][0];
        }
        
        int[][] storage = new int[matrix.length][matrix[0].length];
        
        int[][] visited = new int[matrix.length][matrix[0].length];
        
        max = 0;
        
        for(int i = 0; i < matrix.length; i++) {
        
            for(int j = 0; j < matrix[0].length; j++) {
            
                
                dfs(matrix, i, j, Integer.MIN_VALUE, storage, visited);
            
            }
        }
                
        return max;
    }
    
    public int dfs(int[][] matrix, int x, int y, int prev, int[][] storage, int[][] visited) {
        
        if (x < 0 || y < 0 || x > matrix.length - 1 || y > matrix[0].length - 1 || matrix[x][y] <= prev ||
            visited[x][y] == 1) {
     
            return 0;
        
        }
        
        if(storage[x][y] > 0)
        {
            return storage[x][y];        
        }
        
        visited[x][y] = 1;
        
        int top = dfs(matrix, x - 1, y, matrix[x][y], storage, visited);
        
        int down = dfs(matrix, x + 1, y, matrix[x][y], storage, visited);
        
        int left = dfs(matrix, x, y - 1, matrix[x][y], storage, visited);
        
        int right = dfs(matrix, x, y + 1, matrix[x][y], storage, visited);
        
         int maxtopdown = Math.max(top, down);
    
        
        int maxleftright = Math.max(left, right);
        
    int result = 1 + Math.max(maxtopdown, maxleftright);
        
        
        max = Math.max(max, result);
        
       storage[x][y] = result;
        
        visited[x][y] = 0;
        
        return result;
    }
}