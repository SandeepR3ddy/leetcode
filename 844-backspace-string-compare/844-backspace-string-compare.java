class Solution {
    
    public boolean backspaceCompare(String s, String t) {
     
        int i = s.length()-1, j = t.length()-1;
        
        int skipSchars = 0, skipTchars = 0;
        
        while(i >= 0 || j >= 0)
        {
            
            while(i >= 0)
            {
                if(s.charAt(i) == '#')
                {
                    skipSchars++;
                    // i--;
                }
                else if(skipSchars > 0)
                {
                    skipSchars--;
                     // i--;
                }
                else
                {
                    break;
                }
                i--;
            }
            
            
            while(j >= 0)
            {
                if(t.charAt(j) == '#')
                {
                    skipTchars++;
                    // j--;
                }
                else if(skipTchars > 0)
                {
                    skipTchars--;
                    // j--;
                }
                else
                {
                    break;
                }
                j--;
            }
            
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j))
            {
                return false;
            }
            
            if((i >= 0) != (j >= 0))
            {
                return false;
            }
            
            i--;
            j--;
            
            
        }
        
        return true;
    }
}