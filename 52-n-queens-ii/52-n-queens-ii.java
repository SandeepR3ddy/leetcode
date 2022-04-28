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
    
    public int solveNQueens(boolean[][] boxes,int tq,int bno)
    {
        int n = boxes.length;
        
        if(tq == 0)
        {
            return 1;
        }
        
        int count = 0;
        
        for(int bidx = bno;bidx < n*n;bidx++)
        {
            int row = bidx/n , col = bidx%n;
            
            if(isSafeToPlaceQueen(boxes,row,col))
            {
               boxes[row][col] = true;
                
               count += solveNQueens(boxes,tq-1,bidx+1); 
                
               boxes[row][col] = false; 
            }
        }
        return count;
    }
    
    public int totalNQueens(int n) {
        
        boolean[][] boxes = new boolean[n][n];
        
        return solveNQueens(boxes,n,0);
        
    }
}