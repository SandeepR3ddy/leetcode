class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int ele : nums)
        {
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(
         (a, b) -> {
             return map.get(a) - map.get(b);
         }
        );
        
        for(int key : map.keySet())
        {
            pq.add(key);
            
            if(pq.size() > k)
            {
                pq.remove();
            }
        }
        
        int[] res = new int[pq.size()];
        
        for(int i = 0;i < res.length;i++)
        {
            res[i] = pq.remove();
        }
        return res;
    }
}