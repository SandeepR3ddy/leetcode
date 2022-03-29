class Solution {
    
    public int solve(int sr,int sc,int dr,int dc,int[][] dp,int[][] obstacleGrid)
    {
        if(sr == dr && sc == dc)
        {
            return 1;
        }
        
        int count = 0;
        
        if(dp[sr][sc] != 0)
        {
            return dp[sr][sc];
        }
        
        if(sr-1 >= 0 && obstacleGrid[sr-1][sc] != 1)
        {
            count += solve(sr-1,sc,dr,dc,dp,obstacleGrid);   
        }
        if(sc - 1 >= 0 && obstacleGrid[sr][sc-1] != 1)
        {
            count += solve(sr,sc-1,dr,dc,dp,obstacleGrid);
        }
        if(sr - 1 >= 0 && sc-1 >= 0 && obstacleGrid[sr-1][sc] == 1 && obstacleGrid[sr][sc-1] == 1)
        {
            return 0;
        }
        dp[sr][sc] = count;
       
        return count;
    }
    
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        if(obstacleGrid[m-1][n-1] == 1)
        {
            return 0;
        }
        
        return solve(m-1,n-1,0,0,new int[m][n],obstacleGrid);
    }
}