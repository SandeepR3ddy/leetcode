class Solution {
    
    public int findceil(int val,ArrayList<Integer> seq)
    {
        int low = 0;
        
        int high = seq.size()-1;

        int ceil = Integer.MIN_VALUE; 
        
        while(low <= high)
        {
          int mid = (low+high)/2;
            
            int key = seq.get(mid);
            
            if(key == val)
            {
                return mid;
            }
            else if(key < val)
            {
                low = mid+1;
            }
            else
            {
                ceil = mid;
                high = mid-1;
            }
        }
        return ceil;
    }
    
    
    
    public int lengthOfLIS(int[] nums) {
        
        
        int[] dp = new int[nums.length];
         
        ArrayList<Integer> seq = new ArrayList<>();
        
        for(int i = 0;i < nums.length;i++)
        {
            if(seq.size() == 0 || seq.get(seq.size()-1) < nums[i])
            {
                seq.add(nums[i]);
            }
            else
            {
              
                int ceilindex = findceil(nums[i],seq);
                
                seq.set(ceilindex, nums[i]);
                
            }
         
        }
        return seq.size();
    }
}