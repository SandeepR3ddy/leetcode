class Solution {
    
    public int kthSmallest(int[][] matrix, int k) {
         
        int n = matrix.length, m = matrix[0].length;
        
     PriorityQueue<Integer> pq = new PriorityQueue<>( (a, b) -> {
                                                     
        int i1 = a/m, j1 = a%m;
        int i2 = b/m, j2 = b%m;
                                                     
        return matrix[i1][j1] - matrix[i2][j2];});
         
         for(int i = 0;i < n;i++)
         {
             pq.add(i*n+0);
         }
         
        while(k-- > 1)
        {
            int idx = pq.remove();
            
            int row = idx/m, col = idx%m + 1;
            
            if(col < m)
            {
                pq.add(row*m+col);
            }
        }
        
        int idx = pq.remove();
            
            int row = idx/m, col = idx%m;
            
            
        return matrix[row][col];
        
        
    }
}