class Solution {
    public int minSetSize(int[] arr) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int val : arr)
        {
            map.put(val, map.getOrDefault(val,0)+1); 
        }
        
        int len = arr.length;
        
        int max1 = 0;
        
        int max2 = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>( (a,b)->{
            
            return map.get(b) - map.get(a);
        });
        
            pq.addAll(map.keySet());
        
        int halfLength = len/2;
        
        int count = 0;
        
        while(halfLength > 0 && pq.size() > 0)
        {
            int val = pq.poll();
            
            halfLength -= map.get(val);
            
            System.out.println(map.get(val));
            
            count++;
            
        }
        
        
        return count;
        
    }
}