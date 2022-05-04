class Solution {
    
    public void sortColors(int[] nums) {
        
              HashMap<Integer,Integer> map = new HashMap<>();
        
           for(int val : nums)
           {
              map.put(val, map.getOrDefault(val,0)+1);    
           }
           
        int idx = 0;
        
        int val = map.getOrDefault(0,0);
 
        while(val-- > 0)
        {
            nums[idx++] = 0;
        }
        
         val = map.getOrDefault(1,0);
 
        while(val-- > 0)
        {
            nums[idx++] = 1;
        }
        
         val = map.getOrDefault(2,0);
 
        while(val-- > 0)
        {
            nums[idx++] = 2;
        }
        
        return ;
        
    }
}