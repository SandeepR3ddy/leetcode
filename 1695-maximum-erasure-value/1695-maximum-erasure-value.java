class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
       int i = -1;
        int j = -1;
        
        int n = nums.length;
        
        int sum = 0;
        
        int max = Integer.MIN_VALUE;
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while(i < n-1)
        {
            // sum = 0;
            while(i < n-1)
            {
                i++;
                map.put(nums[i], map.getOrDefault(nums[i],0)+1);
                
                if(map.get(nums[i]) > 1)
                {
                    sum += nums[i];
                   break;    
                }
                
                sum += nums[i];
                
                // System.out.println(nums[i]+" "+sum);
                
                max = Math.max(max, sum);
                
            }
            
            //release the duplicate 
            
            while(j < i)
            {
               j++;
               
               if(map.get(nums[j]) == 1)
               {
                   map.remove(nums[j]);   
                   sum -= nums[j];
               } 
               else
               {
                   map.put(nums[j],1);
                   sum -= nums[j];
                   break;
                   
               }
            }
        }
        return max;
    }
}