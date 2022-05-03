class Solution {
    public boolean isPowerOfTwo(int num) {
       
        int res = 1;
        
      if(num < 0) return false;
        
        for(int i = 1;i < 32;i++)
        {
            if(res == num)
            {
                return true;
            }
            
            res <<= 1;
        }
        
        return false;
    }
}