class Solution {
    
    public int rob(int[] nums) {
    
        int n = nums.length;
        
        int max = nums[0];
        
        if(n == 1)
        {
            return max;
        }
        
        int prev = nums[1];
        
        int sum = 0;
        
        for(int i = 2;i < n;i++)
        {
            
            sum = (max > 0 ? max + nums[i] : nums[i]);
            
            // System.out.println(sum);
            
            max = Math.max(max, prev);
            
            // System.out.println(prev);

            
            prev = sum;
    
        }
    
        return Math.max(max, prev);
        
    }
}