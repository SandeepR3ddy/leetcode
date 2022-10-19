class Solution {
    
    class Pair{
        String str;
        int freq;
        Pair(String str, int freq)
        {
            this.str = str;
            this.freq = freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
    
        Map<String, Integer> map = new HashMap<>();
        
        for(String str : words)
        {
            map.put(str, map.getOrDefault(str,0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
             if(map.get(a.str) == map.get(b.str))
            {
                return a.str.compareTo(b.str);
            }
            else
            {
                return map.get(b.str) - map.get(a.str);        
            }

            });
        
        for(String key : map.keySet())
        {
            pq.add(new Pair(key, map.get(key)));
        }
        
        int size = pq.size();
        
        int count = 0;
        
        List<String> ans = new ArrayList<>();
        
        while(count++ < k)
        {
            ans.add(pq.remove().str);
        }
        return ans;
    }
}