class Solution {
    
    public int longestPalindromicSubseq_(String s, int i,int j, int[][] dp)
    {
        if(i >= j)
        {
            return (i==j)?dp[i][j] = 1 : 0;
        }
            
        if(dp[i][j] != 0)
        {
            return dp[i][j];
        }
        
        int equal = longestPalindromicSubseq_(s,i+1,j-1,dp);
        
        int leaveLeft = longestPalindromicSubseq_(s,i+1,j,dp);
        
        int leaveRight = longestPalindromicSubseq_(s,i,j-1,dp);
        
        if(s.charAt(i) == s.charAt(j))
        {
            return dp[i][j] = equal+2;
        }
        else
        {
            return dp[i][j] = Math.max(leaveLeft,leaveRight);   
        }   
    }
    
    
    public int longestPalindromeSubseq(String s) {
        
        int n = s.length();
        
        int i = 0, j = n-1;
        
        int[][] dp = new int[n+1][n+1];
        
      return  longestPalindromicSubseq_(s,i,j,dp);
     
    }
}