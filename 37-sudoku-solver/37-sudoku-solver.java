class Solution {
    
    public boolean isPossibleToPlaceNumber(char[][] board,int row,int col,int num)
    {
       //row checking
        
        for(int i = 0;i < 9;i++)
        {
           if((board[i][col]-'0') == num) 
              return false; 
        }
    
      //column checking
     
        for(int i = 0;i < 9;i++)
        {
           if((board[row][i]-'0') == num) 
              return false; 
        }
     
        //checking 3/3 matrix around it
        
        row = (row/3)*3;
        col = (col/3)*3;
        
        for(int i = 0;i < 3;i++)
        {
          for(int j = 0;j < 3;j++)
          {
              if((board[row+i][col+j] - '0') == num)
                  return false;
          }
        }
        return true;
    }
    
    public boolean solveSudoku(char[][] board,List<Integer> list,int idx)
    {
        if(idx == list.size())
        {
         return true;   
        }
        
        int row = list.get(idx)/9;
        int col = list.get(idx)%9;
        
        for(int num = 1;num <= 9;num++)
        {
            if(isPossibleToPlaceNumber(board,row,col,num))
            {
                board[row][col] = (char)('0' + num);
               if(solveSudoku(board,list,idx+1))
               {
                   return true;
               }
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
        
        ArrayList<Integer> list = new ArrayList<>(); //to store blank spaces
        
        for(int i = 0;i < 9;i++)
        {
          for(int j = 0;j < 9;j++)
            {
               if(board[i][j] == '.')
               {
                 list.add((i*9+j));    
               }
          }
        }
        solveSudoku(board,list,0);
        return;
    }
}