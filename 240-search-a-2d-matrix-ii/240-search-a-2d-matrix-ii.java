class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     
        
        int rows = matrix.length;
        
        int i = 0;
        int j = matrix[0].length-1;
        
        
        while(i < rows && j >= 0)
        {
            if(matrix[i][j] == target)
            {
                return true;
            }
            else if(target > matrix[i][j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return false;
        
    }
}