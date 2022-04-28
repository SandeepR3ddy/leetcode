class Solution {
    
    public boolean isSafeToPlaceQueen(boolean[][] boxes,int row,int col)
    {
   
        int[][] dirs = {{0,-1},{-1,-1},{-1,0},{-1,1}}; 
    
        int n = boxes.length;
        
        for(int d = 0;d < dirs.length;d++)
        {
            for(int rad = 1;rad <= n;rad++)
            {
                int x = row + (rad*dirs[d][0]);
                int y = col + (rad*dirs[d][1]);
                
                if(x >= 0 && y >= 0 && x < n && y < n)
                {
                    if(boxes[x][y])
                    {
                        return false;
                    }
                }
                else
                {
                   break;    
                }
            }
        }
     return true;
    }
    
    public void solveNQueens(boolean[][] boxes,int tq,int bno,List<List<String>> ans)
    {
        int n = boxes.length;
        
        if(tq == 0)
        {
            List<String> smallans = new ArrayList<>();
            
           for(int i = 0;i < n;i++)
           {
               StringBuilder sb = new StringBuilder("");
               
               for(int j = 0;j < n;j++)
               {
                   if(boxes[i][j] == false)
                   {
                      sb.append(".");
                   }
                   else
                   {
                      sb.append("Q");   
                   }
               }
               
              smallans.add(sb.toString()); 
           }
            ans.add(smallans);
        }
        
        for(int bidx = bno;bidx < n*n;bidx++)
        {
            int row = bidx/n , col = bidx%n;
            
            if(isSafeToPlaceQueen(boxes,row,col))
            {
               boxes[row][col] = true;
                
               solveNQueens(boxes,tq-1,bidx+1,ans); 
                
               boxes[row][col] = false; 
            }
        }
        return;
    }
    
    public List<List<String>> solveNQueens(int n) {
    
      boolean[][] boxes = new boolean[n][n];
        
      List<List<String>> ans = new ArrayList<>();
        
      solveNQueens(boxes, n, 0,ans);
        
      return ans;  
    }
    
}