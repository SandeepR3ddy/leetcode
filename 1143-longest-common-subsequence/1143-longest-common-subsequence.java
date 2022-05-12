class Solution {
    
    public int longestCommonSubsequence(String str1, String str2, int n, int m, int[][] dp)
    {
        if(n == 0 || m == 0)
        {
         return  dp[n][m] = 0;
        }
        if(dp[n][m] != -1)
        {
            return dp[n][m]; 
        }
        
        int same = longestCommonSubsequence(str1, str2, n-1, m-1, dp);
        
        int leaveright = longestCommonSubsequence(str1, str2, n-1, m, dp);
        
        int leaveleft = longestCommonSubsequence(str1, str2, n, m-1, dp);
        
        if(str1.charAt(n-1) == str2.charAt(m-1))
        {
            return dp[n][m] = same+1;
        }
        else
        {
            return dp[n][m] = Math.max(leaveleft, leaveright);
        }
    }
    
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n = text1.length();
        int m = text2.length();
        
        int[][] dp = new int[n+1][m+1];
        
        for(int[] d : dp)
        Arrays.fill(d,-1);
        
        return longestCommonSubsequence(text1,text2, n,m, dp);
        
        
    }
}