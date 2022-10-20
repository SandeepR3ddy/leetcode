class Solution {
    
    public int solve(String s, int idx,int[] dp)
    {
        if(idx == s.length())
        {
            return dp[idx] = 1;
        }
        
        if(s.charAt(idx) == '0')
        {
            return dp[idx] = 0;
        }
        
        if(dp[idx] != 0)
        {
            return dp[idx];
        }
        
        int count = 0;
        
        count += solve(s, idx+1,dp);
        
        if(idx + 1 < s.length())
        {
             int val = Integer.parseInt(s.substring(idx,idx+2));
                if(val <= 26)
                {
                    
            count += solve(s, idx+2,dp);
        }
        }
        return dp[idx] = count;
        
    }
    
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length()+1];
        
        solve(s, 0, dp);
    
        return dp[0];
    }
}