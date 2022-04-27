class Solution {
    public int tribonacci(int N) {
        
        int[] dp = new int[N+1];
        
        for(int n = 0;n <= N;n++)
        {
            if(n <= 1)
            {
                dp[n] = n;
                continue;
            }
            else if(n == 2)
            {
                dp[n] = 1;
            }
            else
            {
              dp[n] = dp[n-1]+dp[n-2]+dp[n-3];    
            }
        }
        return dp[N];
    }
}