class Solution {
    
    public boolean isLongPressedName(String name, String typed) {
      
         int len1 = name.length();
        
         int len2 = typed.length();
        
         int i = 0, j = 0;
         
        if(len2 < len1)
        {
            return false;
        }
        
        while(j < len2)
        {
            
            if(i < len1 && name.charAt(i) == typed.charAt(j))
            {
                i++;
                j++;
            }
            else if(j > 0 && typed.charAt(j) == typed.charAt(j-1))
            {
                j++;
            }
            else
            {
                return false;
            }           
        }
        return (i == len1);
    }
}