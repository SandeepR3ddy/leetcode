class Solution {
    
    private void letterCombinations(String digits,int idx, String[] codes,List<String> ans, String psf)     {
        if(idx == digits.length())
        {
           ans.add(psf);
            return;
        }
        
        int val = digits.charAt(idx)-'0';
        
        String word = codes[val];
        
        for(int i = 0;i < word.length();i++)
        {
            letterCombinations(digits,idx+1,codes,ans,psf+ word.charAt(i));
        }
        
        return;
    }
     
    
   
    public List<String> letterCombinations(String digits) {
        
       List<String> ans = new ArrayList<>();
       
       if(digits.length() == 0)
       {
           return ans;
        }
        
        
       String[] codes =  {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"}; 
        
       letterCombinations(digits,0,codes,ans,""); 
     
        return ans;
        
    }
}