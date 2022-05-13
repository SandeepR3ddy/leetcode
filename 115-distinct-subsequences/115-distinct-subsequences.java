class Solution {
    
    public int numDistinct(String s, String t, int n,int m,int[][] dp)
    {
        if(n == 0 || m == 0)
        {
            return dp[n][m] = (m==0)? 1:0 ;
        }
        if(dp[n][m] != -1)
        {
            return dp[n][m];
        }
        
        int equal = numDistinct(s,t,n-1,m-1,dp);
        int leaveleft = numDistinct(s,t,n-1,m,dp);
        
        if(s.charAt(n-1) == t.charAt(m-1))
        {
            return dp[n][m] = equal + leaveleft;
        }
        else
        {
            return dp[n][m] = leaveleft;
        }
    }
    
    
    public int numDistinct(String s, String t) {
        
        int n = s.length();
        int m = t.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] d : dp)
        Arrays.fill(d,-1);
        
        return numDistinct(s,t,n,m,dp);
        
        
    }
}