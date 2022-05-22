class Solution {
   
    public int countSubstrings(String s, int left, int right, int[][] dp)
    {
        if(left >= right)
        {
            return dp[left][right] = 1;
        }
        
        if(dp[left][right] != -1)
        {
            return dp[left][right];
        }
        
        if(s.charAt(left) == s.charAt(right))
        {
            return dp[left][right] = countSubstrings(s,left+1,right-1,dp);
        }
        return dp[left][right] = 0;
        
    }
    
    public int countSubstrings(String s) {
       
        int n = s.length();
        
        int[][] dp = new int[n+1][n+1];
       
        for(int[] d : dp)
        {
          Arrays.fill(d,-1);   
        }
    
        int count = 0;
        
        for(int i = 0;i < n;i++)
        {
          for(int j = i;j < n;j++)
          {
              if(countSubstrings(s,i,j,dp) == 1)
              {
                count++;
              }
          }
        }
       return count;
    }
}