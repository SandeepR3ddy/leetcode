class Solution {
    public int[] singleNumber(int[] nums) {
        
        int res = 0;
        
        for(int val : nums)
        {
            res ^= val;
        }
        
        int res1 = 0;
        int res2 = 0;
        
        int rmbs = (res & (-res)); 
        
        
        for(int val : nums)
        {
            if((val&rmbs) == 0)
            {
                res1 ^= val;
            }
            else
            {
                res2 ^= val;
            }
        }
        
        return new int[]{res1,res2};
        
    }
}