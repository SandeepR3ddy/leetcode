class Solution {
    
    public int solve(int sr,int sc,int dr,int dc,int[][] dp)
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
        
        if(sr-1 >= 0)
        {
            count += solve(sr-1,sc,dr,dc,dp);   
        }
        if(sc - 1 >= 0)
        {
            count += solve(sr,sc-1,dr,dc,dp);
        }
        
        dp[sr][sc] = count;
       
        return count;
    }
     public int uniquePaths(int m, int n) {
        
        int[][] dp = new int[m][n];
        
        return solve(m-1,n-1,0,0,dp);
        
    }
}