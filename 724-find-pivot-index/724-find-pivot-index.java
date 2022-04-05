class Solution {
    public int pivotIndex(int[] nums) {
        
        int totalsum = 0;
        
        for(int val : nums)
        {
            totalsum += val;
        }
        
        int rightsum = totalsum - nums[0];
        
        if(rightsum == 0)
        {
           return 0; 
        }
        
        int leftsum = 0;
        
        for(int i = 1;i < nums.length;i++)
        {
            rightsum -= nums[i];
            leftsum += nums[i-1];
            
            if(leftsum == rightsum)
            {
                 return i;
            }
        }
        return -1;
    }
}