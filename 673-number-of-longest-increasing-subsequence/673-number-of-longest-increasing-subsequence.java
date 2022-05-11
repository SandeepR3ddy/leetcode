class Solution {
    public int findNumberOfLIS(int[] nums) {
        
        int maxLength = 0, maxCount = 0;
        
        int n = nums.length;
        
        int[] length = new int[n];
        int[] count = new int[n];
        
        for(int i = 0;i < n;i++)
        {
           length[i] = 1;
           count[i] = 1;
            
            for(int j = i-1;j >= 0;j--)
            {
                if(nums[j] < nums[i])
                {
                if(length[j] + 1 == length[i])
                {
                    count[i] += count[j];
                }
                else if(length[j] + 1 > length[i])
                {
                    length[i] = length[j] + 1;
                    count[i] = count[j];
                }
                }
            }
            
            if(length[i] > maxLength)
            {
                maxLength = length[i];
                maxCount = count[i];
            }
            else if(length[i] == maxLength)
            {
               maxCount += count[i];    
            }
        }
        return maxCount;
    }
}