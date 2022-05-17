class Solution {

    public class Pair
    {
        int i;
        int j;
        int time;
        
        Pair(){
            
        }
        
        Pair(int i, int j, int time)
        {
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    
    
    
    
    
    public int orangesRotting(int[][] grid) {
        
        int freshOranges = 0;
        
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        
        for(int i  = 0;i < grid.length;i++)
        {
            for(int j = 0;j < grid[0].length;j++)
            {
               if(grid[i][j] == 2)
               {
                 queue.add(new Pair(i,j, 0));           
               }
                else if(grid[i][j] == 1)
                {
                    freshOranges++;
                }
            }
        }
        //bfs
        
        int ans = 0;
        
        int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
        
       while(queue.size() > 0)
       {
           Pair rem = queue.remove();
           
           ans = rem.time;
           
           for(int d = 0; d < dir.length;d++)
           {
              int newi = rem.i + dir[d][0];
              int newj = rem.j + dir[d][1];
           
             if(newi >= 0 && newi < grid.length && newj >= 0 && newj < grid[0].length && grid[newi][newj] == 1)
             {
                 queue.add(new Pair(newi, newj, rem.time+1));
                 grid[newi][newj] = 2;
                 freshOranges--;  
             }
           }
       }
        
        
    return freshOranges == 0 ? ans:-1;
        
    }
}