class Solution {
    
    
        int[] count0 ;
    
        int[] count1 ; 
        
        int[][][] dp ; 
        
    
    public int solve(int idx, int m,int n)
    {
        if(n < 0 || m < 0)
        {
            return Integer.MIN_VALUE; //no value from this
        }
        if(idx == count0.length)
        {
           return 0;  //idx out of bound
        }
        if(dp[idx][m][n] != -1)
        {
            return dp[idx][m][n];
        }
        
       return dp[idx][m][n] = Math.max(solve(idx+1, m - count0[idx], n-count1[idx]) + 1,   solve(idx+1, m,n));
        
    }
    
    
    public int findMaxForm(String[] strs, int m, int n) {
        
        int len = strs.length;
        
        count0 = new int[len];
        
        count1= new int[len];
        
        dp= new int[len+1][m+1][n+1];
        
        for(int i = 0;i < len;i++)
        {
            for(char ch : strs[i].toCharArray())
            {
                if(ch == '0')
                {
                    count0[i]++;
                }
                else if(ch == '1')
                {
                    count1[i]++;
                }
            }
        }
        for(int[][] x : dp)
        {
            for(int[] y : x)
            {
                Arrays.fill(y,-1);
            }
        }
        return solve(0, m, n);
        
        }
}