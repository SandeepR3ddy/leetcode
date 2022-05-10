class Solution {
    
    public static void transpose(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0;i < n;i++)
        {
          for(int j = 0;j < i;j++)
          {
             
            int temp = matrix[i][j];
             matrix[i][j] = matrix[j][i];
                matrix[j][i]= temp;
             }
        }
        return;
    }
    
    public static void reverseRow(int[][] matrix)
    {
        int n = matrix.length;
        
        for(int i = 0;i < n;i++)
        {
            for(int j = 0;j < n/2;j++)
            {
             
            int temp = matrix[i][j];
             matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1]= temp;
             
           }
        }
    }
    
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
        
        reverseRow(matrix);
        return;
        
    }
}