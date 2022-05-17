class Solution {
    
    public class Pair
    {
        int i;
        int j;
        
        Pair(){
            
        }
        
        Pair(int i, int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    
    
    public int[][] updateMatrix(int[][] mat) {
        
        int rows = mat.length;
        int cols = mat[0].length;
        
        int[][] res = new int[rows][cols];
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for(int i = 0;i < rows;i++)
        {
            for(int j = 0;j < cols;j++)
            {
                if(mat[i][j] == 0)
                {
                    queue.add(new Pair(i,j));
                }
            }
        }
        
        //bfs
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
        while(queue.size() > 0)
        {
            Pair rem = queue.remove();
            
            for(int d = 0; d < dir.length;d++)
            {
             
                int ni = rem.i + dir[d][0];
                int nj = rem.j + dir[d][1];
                
                if(ni >= 0 && ni < rows && nj >= 0 && nj < cols && mat[ni][nj] == 1)
                {
                    res[ni][nj] = res[rem.i][rem.j]+1;
                    
                    queue.add(new Pair(ni,nj));
                    
                    mat[ni][nj] = -1;
                }
            }
        }
        return res;
    }
}