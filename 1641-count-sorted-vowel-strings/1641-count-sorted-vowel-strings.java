class Solution {
    
    public int count(int n, String str, int idx)
    {
        if(n == 0)
        {
            return 1;
        }
        int ct = 0;
        
        for(int i = idx;i < str.length();i++)
        {
            ct += count(n-1,str,i); 
        }
        
        return ct;
    }
    
    public int countVowelStrings(int n) {
        
        String str = "aeiou";
        
        return count(n,str, 0);
        
    }
}