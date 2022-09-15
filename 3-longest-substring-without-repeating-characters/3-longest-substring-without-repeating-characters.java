class Solution {
    public int lengthOfLongestSubstring(String s) {
     
        int n = s.length(), i  = 0, j = 0, len = 0;
        
        int[] freq = new int[128];
        
        int count = 0;
        
        while(j < n)
        {
            
            freq[s.charAt(j)]++;
            
            if(freq[s.charAt(j)] == 2)
            {
                count++;
            }
            
            j++;
            
            while(count > 0)
            {
                
                freq[s.charAt(i)]--;
                
                if(freq[s.charAt(i)] == 1)
                {
                    count--;
                }
                
                i++;
            }
            
            len = Math.max(len, j-i);
        }
        return len;
    }
}