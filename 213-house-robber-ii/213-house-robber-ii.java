class Solution {
    
    public int rob(int[] nums, int start, int end)
    {
        if(end-start == 0)
        {
            return nums[start];
        }
        
        int max = nums[start];
        
        int prev = nums[start+1];
        
        for(int i = start+2;i <= end;i++)
        {
            int sum = (max > 0 ? max + nums[i] : nums[i]);
            
            max = Math.max(max, prev);
            
            prev = sum;
            
        }
        
        return Math.max(max, prev);
        
    }
    
    public int rob(int[] nums) {
        
        //there are two ways
        
        //rob from 2nd house and till last
        
        //rob from 1st and leave last
        
        // return max of both
        
        
        int n = nums.length;
        
        if(n == 1)
        {
           return nums[0];
            }
        
        return Math.max(rob(nums, 0, n-2),rob(nums,1,n-1)); 
        
        
    }
}