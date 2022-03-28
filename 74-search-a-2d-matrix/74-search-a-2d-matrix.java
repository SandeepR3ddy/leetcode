class Solution {
    
    public int findrow(int[][] matrix,int target)
    {
        int low = 0;
        int high = matrix.length - 1 ;
        
        int lastcol = matrix[0].length - 1;
        
        while(low <= high)
        {
            
            int mid = (low + high)/2;
            
            if(target >= matrix[mid][0] && target <= matrix[mid][lastcol])
            {
                return mid;
            }
            else if(target > matrix[mid][lastcol])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return -1;
    }
    
    public boolean checkcol(int[][] matrix,int potrow,int target)
    {
        int low = 0;
        int high = matrix[0].length - 1;
        
        while(low <= high)
        {
            int mid = (low + high)/2;
            
            if(target == matrix[potrow][mid])
            {
                return true;
            }
            else if(target > matrix[potrow][mid])
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return false;   
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        
    int potentialrow = findrow(matrix,target);
    
    if(potentialrow == -1)
    {
        return false;
    }
        
    return checkcol(matrix,potentialrow,target);  
    }
}