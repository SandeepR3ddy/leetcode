class Solution {
    public boolean isAnagram(String s, String t) {
     
        HashMap<Character, Integer> map1 = new HashMap<>();
        
        for(Character ch : s.toCharArray())
        {
            map1.put(ch, (map1.getOrDefault(ch,0)+1));
        }
        
        // HashMap<Character, Integer> map2 = new HashMap<>();
        
        for(Character ch : t.toCharArray())
        {
            if(map1.containsKey(ch))
            {
                int val = map1.get(ch);
                if(val == 1)
                {
                    map1.remove(ch);
                }
                else
                {
                    map1.put(ch, map1.get(ch)-1);
                }
            }
            else
            {
                return false;
            }
        }
        
        if(map1.size() != 0)
        {
            return false;
        }
        
        return true;
        
    }
}