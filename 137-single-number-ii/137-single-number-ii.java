class Solution {
    public int singleNumber(int[] nums) {
        
        int res = 0;

        for(int i = 0;i < 32;i++)
        {
            int count = 0;
            
            for(int j = 0;j < nums.length;j++)
            {
               if((nums[j] & 1) == 1)
               {
                 count++;          
               }
                nums[j] = (nums[j] >> 1);
            }
         if(count % 3 == 1)
         {
            res = (res | (1 << i));             
         }
    }
        return res;
   }
}