class Solution {
    
    public int maxOperations(int[] nums, int k) {
    
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : nums)
        {
            map.put(val, map.getOrDefault(val,0)+1);
        }
        
        int count = 0;
        
        for(int key : map.keySet())
        {
            if(k%2 == 0 && key == k/2)
            {
                count += 2*(map.get(key)/2);
            }
            else
            {
                if(map.containsKey(k-key))
                {
                    count += Math.min(map.get(key),map.get(k-key)) ;
                }
            }
            
        }
        return count/2 ;
    }
}