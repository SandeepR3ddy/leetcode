class Solution {
    
    public int firstMissingPositive(int[] nums) {
        
     int n = nums.length;
        
     boolean onePresent = false;
        
       for(int i = 0;i < n;i++)
       {
           if(nums[i] == 1)
           {
               onePresent = true;
           }
           else
           {
              if(nums[i] < 1 || nums[i] > n)
              {
                  nums[i] = 1;    
              }
           }
       }
       if(!onePresent)
       {
           return 1;
       }
       
       for(int i = 0;i < n;i++)
       {
               int val = Math.abs(nums[i]);
               
               nums[val-1] = -(Math.abs(nums[val-1])); // because for n it is not marked as 1
       }
        for(int i = 0;i < n;i++)
        {
            if(nums[i] > 0)
            {
                return i+1;
            }
        }
        return n+1;
    }
}