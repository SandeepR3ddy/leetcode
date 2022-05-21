class Solution {
    private int solve(int[] coins, int amount, int[] dp) {
       
        if(amount == 0)
        {
           return dp[0] = 0;    
        }
        
        if(dp[amount] != -1)
        {
           return dp[amount];    
        }
        
        int min = (int)1e9;
        
        for(int i = 0;i < coins.length;i++)
        {
            
            if(amount - coins[i] >= 0)
            {
                min = Math.min(min, solve(coins,amount-coins[i],dp)+1);
            }
        }
        return dp[amount] = min;
    }
    public int coinChange(int[] coins,int amount) {
        
        int[] dp = new int[amount+1];
        
        Arrays.fill(dp,-1);
        
       int ans =  solve(coins,amount, dp);
        
       return (dp[amount] != (int)1e9) ? dp[amount] : -1;  
        
        
    }
}