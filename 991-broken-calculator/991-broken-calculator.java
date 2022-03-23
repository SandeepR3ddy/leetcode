class Solution {
   
    public int brokenCalc(int startValue, int target) {
    
        int count = 0;
        
        if(target < startValue)
        {
            return startValue - target;
        }
        while(startValue < target)
        {
            if(target%2 == 0)
            {
                target /= 2;
            }
            else
            {
                target++;
            }          
               count++;
        }
        if(target < startValue)
        {
            while(target != startValue)
            {
                count++;
                target++;
            }
        }
        
        
        
        return count;
        
    }
}