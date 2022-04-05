class Solution {
    public int pivotIndex(int[] nums) {
        
        int totalsum = 0;
        
        for(int val : nums)
        {
            totalsum += val;
        }
        
        int rightsum = totalsum;
        
        int leftsum = 0;
        
        for(int i = 0;i < nums.length;i++)
        {
            rightsum -= nums[i];
            if(leftsum == rightsum)
            {
                 return i;
            }
            
            leftsum += nums[i];
            
        }
        return -1;
    }
}