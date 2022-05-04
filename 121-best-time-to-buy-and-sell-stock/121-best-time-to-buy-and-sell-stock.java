class Solution {
    public int maxProfit(int[] prices) {
        
        int max = 0;
        
        int n = prices.length;
        
        int[] gtnext = new int[n];
        
        gtnext[n-1] = prices[n-1];
        
        for(int i = n-2;i >= 0;i--)
        {
            gtnext[i] = Math.max(gtnext[i+1],prices[i]);
        }
        
        for(int i = 0;i < n;i++)
        {
            max = Math.max(max,(gtnext[i] - prices[i]));
        }
        return max;
    }
}