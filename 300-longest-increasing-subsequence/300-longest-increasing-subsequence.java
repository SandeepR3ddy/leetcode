class Solution {
    public int lengthOfLIS(int[] nums) {
        
        
        int[] dp = new int[nums.length];
        
        dp[0] = 1;
        
        int omax = dp[0];
        
        for(int i = 1;i < nums.length;i++)
        {
            int max = 0;
            for(int j = i-1;j >= 0;j--)
            {
                 if(nums[j] < nums[i])
                 {
                     max = Math.max(max,dp[j]);
                 }
            }
            dp[i] = max+1;
            omax = Math.max(dp[i],omax);
        }
        return omax;
    }
}